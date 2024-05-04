import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:starfish_tenement_app/common_ui/app_bar/app_title_bar.dart';
import 'package:starfish_tenement_app/common_ui/title/app_title.dart';
import 'package:starfish_tenement_app/styles/app_colors.dart';

import '../../datas/news_type_data.dart';
import 'news_type_vm.dart';

class NewsTypePage extends StatefulWidget {
  const NewsTypePage({super.key});

  @override
  State createState() {
    return _NewsTypePageState();
  }
}

class _NewsTypePageState extends State<NewsTypePage> {
  NewsTypeViewModel _viewModel = NewsTypeViewModel();

  @override
  void initState() {
    super.initState();
    _viewModel.getNewsTypeList();
  }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
        create: (context) {
          return _viewModel;
        },
        child: Scaffold(
            body: SafeArea(
                child: Column(children: [
          AppTitleBar(title: "资讯", onRightTap: () {}),
          Expanded(
              child: Padding(
                  padding: EdgeInsets.only(left: 17.w, right: 14.w),
                  child: Consumer<NewsTypeViewModel>(
                    builder: (context, vm, child) {
                      return ListView.builder(
                          itemBuilder: (context, index) {
                            return _itemView(vm.data?[index]);
                          },
                          itemCount: vm.data?.length ?? 0);
                    },
                  )))
        ]))));
  }

  Widget _itemView(NewsTypeListData? item) {
    return Container(
        width: double.infinity,
        decoration: BoxDecoration(
            border: Border(bottom: BorderSide(color: AppColors.lineColorFA, width: 1.r))),
        padding: EdgeInsets.only(top: 15.h, bottom: 14.h),
        child: Row(children: [
          Expanded(
              child: Column(crossAxisAlignment: CrossAxisAlignment.start, children: [
            AppText(
                text: item?.title ?? "",
                fontSize: 20.sp,
                textColor: AppColors.textColor20,
                maxLines: 2),
            //三张图
            if (item?.type == "0")
              Container(
                  width: double.infinity,
                  margin: EdgeInsets.only(top: 20.h),
                  height: 90.h,
                  child: Row(children: [
                    Expanded(
                        flex: 1, child: Image.network(item?.imageList?[0] ?? "", fit: BoxFit.fill)),
                    7.horizontalSpace,
                    Expanded(
                        flex: 1, child: Image.network(item?.imageList?[1] ?? "", fit: BoxFit.fill)),
                    7.horizontalSpace,
                    Expanded(
                        flex: 1, child: Image.network(item?.imageList?[2] ?? "", fit: BoxFit.fill)),
                  ])),
            20.verticalSpace,
            Row(children: [
              AppText(text: "大谈房屋知识 2019.08.08", fontSize: 12.sp, textColor: AppColors.textColorB7),
              const Expanded(child: SizedBox()),
              Image.asset("assets/images/icon_news_type_zhuanfa.png", width: 13.r, height: 13.r),
              13.horizontalSpace,
              Image.asset("assets/images/icon_news_type_dianzan.png", width: 13.r, height: 13.r),
              13.horizontalSpace,
              Image.asset("assets/images/icon_news_type_collect.png", width: 13.r, height: 13.r),
            ])
          ])),
          //单张图
          if (item?.type == "2")
            Container(
                padding: EdgeInsets.only(left: 14.w, right: 3.w),
                child: Image.network(item?.singleImage ?? "",
                    width: 110.w, height: 86.h, fit: BoxFit.fill))
        ]));
  }
}
