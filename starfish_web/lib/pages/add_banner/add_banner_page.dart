import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:starfish_web/common_ui/form_button.dart';
import 'package:starfish_web/common_ui/title/app_title.dart';
import 'package:starfish_web/pages/add_banner/add_banner_vm.dart';
import 'package:starfish_web/styles/app_colors.dart';

import '../../common_ui/card_page.dart';
import '../../common_ui/style/common_styles.dart';
import '../../common_ui/input_form.dart';
import '../../repository/data/banner_list_data.dart';

class AddBannerPage extends StatefulWidget {
  const AddBannerPage({super.key});

  @override
  State createState() {
    return _AddBannerPageState();
  }
}

class _AddBannerPageState extends State<AddBannerPage> {
  AddBannerViewModel viewModel = AddBannerViewModel();

  @override
  void initState() {
    super.initState();
    viewModel.getBannerList();
  }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
        create: (context) {
          return viewModel;
        },
        child: CardPage(
            child: Row(
          children: [
            Expanded(flex: 5, child: _bannerList()),
            Expanded(
                flex: 5,
                child: Consumer<AddBannerViewModel>(
                  builder: (context, vm, child) {
                    return Column(
                        mainAxisAlignment: MainAxisAlignment.start,
                        crossAxisAlignment: CrossAxisAlignment.start,
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          InputForm(text: "图片链接：", inputController: vm.inputImgUrl),
                          20.verticalSpace,
                          InputForm(text: "活动链接：", inputController: vm.inputLink),
                          20.verticalSpace,
                          InputForm(text: "活动名称：", inputController: vm.inputActName),
                          40.verticalSpace,
                          Row(
                            children: [
                              FormButton(text: '清空', bgColor: AppColors.buttonBg, click: () {
                                vm.clearCurrItem();
                              }),
                              10.horizontalSpace,
                              FormButton(text: '确定添加', click: () {
                                if(vm.currentItem?.id==null){
                                  vm.addBanner();
                                }else{
                                  vm.updateBanner();
                                }

                              }),
                            ],
                          ),
                        ]);
                  },
                ))
          ],
        )));
  }

  Widget _bannerList() {
    return Consumer<AddBannerViewModel>(builder: (context, vm, child) {
      return ListView.builder(
          itemCount: vm.bannerList?.length ?? 0,
          itemBuilder: (context, index) {
            return _bannerInfoItem(vm.bannerList?[index]);
          });
    });
  }

  Widget _bannerInfoItem(BannerListItemData? item) {
    return Container(
      padding: EdgeInsets.only(top: 20.h, bottom: 20.h),
      margin: EdgeInsets.only(left: 15.w, right: 45.w),
      decoration:
          BoxDecoration(border: Border(bottom: BorderSide(width: 1.r, color: AppColors.lineColor))),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          AppText(
            text: "活动名称：${item?.activename}",
            fontSize: 9.sp,
          ),
          Row(
            children: [
              Expanded(child: SizedBox()),
              Text("状态：${viewModel.getStatus(item?.status)}"),
              10.horizontalSpace,
              itemClickText(
                  text: "删除",
                  textColor: Colors.red,
                  onTap: () {
                    viewModel.delBanner("${item?.id}");
                  }),
              10.horizontalSpace,
              itemClickText(text: "编辑", onTap: () {
                viewModel.setCurrItem(item);
              }),
            ],
          )
        ],
      ),
    );
  }

  Widget itemClickText({String? text, GestureTapCallback? onTap, Color? textColor}) {
    return GestureDetector(
      onTap: onTap,
      child: Text(
        text ?? "",
        style: TextStyle(color: textColor ?? Colors.blue, decoration: TextDecoration.underline),
      ),
    );
  }
}
