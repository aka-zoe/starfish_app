import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter_swiper_view/flutter_swiper_view.dart';
import 'package:provider/provider.dart';
import 'package:starfish_tenement_app/common_ui/tag/tag_widget.dart';
import 'package:starfish_tenement_app/common_ui/title/app_title.dart';
import 'package:starfish_tenement_app/common_ui/title/home_big_title.dart';
import 'package:starfish_tenement_app/route/Routes.dart';
import 'package:starfish_tenement_app/route/route_utils.dart';
import 'package:starfish_tenement_app/styles/app_colors.dart';

import '../../datas/news_banner_data.dart';
import 'news_list_vm.dart';

///资讯页
class NewsListPage extends StatefulWidget {
  const NewsListPage({super.key});

  @override
  State createState() {
    return _NewsListPageState();
  }
}

class _NewsListPageState extends State<NewsListPage> {
  final NewsListViewModel _vm = NewsListViewModel();

  @override
  void initState() {
    super.initState();
    _vm.getBanner();
  }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
        create: (context) {
          return _vm;
        },
        child: Scaffold(
            body: SafeArea(
                child: Padding(
          padding: EdgeInsets.only(left: 20.w),
          child: SingleChildScrollView(
            child: Column(crossAxisAlignment: CrossAxisAlignment.start, children: [
              //大标题
              HomeBigTitle(
                bigTitle: "房产资讯",
                titleSize: 24.sp,
                padding: EdgeInsets.only(top: 21.h, bottom: 17.h),
              ),
              //分割线
              Container(
                width: double.infinity,
                padding: EdgeInsets.only(right: 19.w, top: 17.h),
                height: 1.h,
                color: AppColors.lineColorF8,
              ),
              //最新资讯banner
              _newsBannerWidget(),
              25.verticalSpace,
              //热门资讯标题
              Container(
                  padding: EdgeInsets.only(right: 18.w),
                  child: HomeBigTitle(bigTitle: "热门资讯", showRight: true, onRightTap: () {})),
              //资讯列表
              ListView.builder(
                shrinkWrap: true,
                physics: const NeverScrollableScrollPhysics(),
                itemBuilder: (context, index) {
                  return _newsListItemView(() {
                    RouteUtils.pushForNamed(context, RoutePath.newsTypePage);
                  });
                },
                itemCount: 20,
              )
            ]),
          ),
        ))));
  }

  Widget _newsListItemView(GestureTapCallback? onTap) {
    return GestureDetector(
        onTap: onTap,
        child: Container(
          padding: EdgeInsets.only(top: 20.h, bottom: 20.h),
          margin: EdgeInsets.only(right: 15.w),
          decoration: BoxDecoration(
              border: Border(bottom: BorderSide(color: AppColors.lineColorF8, width: 1.r))),
          child: Row(
            children: [
              ClipRRect(
                  borderRadius: BorderRadius.circular(8.r),
                  child: Image.network(
                      "https://images.pexels.com/photos/101808/pexels-photo-101808.jpeg",
                      width: 103.w,
                      height: 76.h,
                      fit: BoxFit.fill)),
              14.horizontalSpace,
              Expanded(
                  flex: 1,
                  child: Column(crossAxisAlignment: CrossAxisAlignment.start, children: [
                    AppText(
                      maxLines: 2,
                      text: "健康住宅“这个圈”如何才能画满360度？",
                      textColor: AppColors.textColor7C,
                      fontSize: 18.sp,
                    ),
                    Row(crossAxisAlignment: CrossAxisAlignment.center, children: [
                      TagWidget(name: "房产新闻", color: AppColors.textRedColor3D),
                      Expanded(child: SizedBox()),
                      Image.asset("assets/images/icon_news_remark.png", width: 13.r, height: 13.r),
                      6.horizontalSpace,
                      AppText(text: "1234"),
                      12.horizontalSpace,
                      Image.asset("assets/images/icon_news_collect_grey.png",
                          width: 13.r, height: 13.r),
                      6.horizontalSpace,
                      AppText(text: "300"),
                      20.horizontalSpace,
                    ])
                  ]))
            ],
          ),
        ));
  }

  Widget _newsBannerWidget() {
    return Consumer<NewsListViewModel>(builder: (context, vm, child) {
      return SizedBox(
        height: 325.h,
        width: double.infinity,
        child: Swiper(
          //右侧下一页显示一点
          viewportFraction: 0.96,
          itemBuilder: (context, index) {
            return _bannerItemView(vm.banner?[index], index, vm.banner?.length ?? 0);
          },
          itemCount: vm.banner?.length ?? 0,
        ),
      );
    });
  }

  Widget _bannerItemView(NewsBanner? item, int index, int itemCount) {
    return Column(crossAxisAlignment: CrossAxisAlignment.start, children: [
      12.verticalSpace,
      Row(
        children: [
          AppText(text: item?.title ?? "", fontSize: 14.sp, textColor: AppColors.textColor7c),
          const Expanded(child: SizedBox()),
          AppText(text: "0${index + 1}/", fontSize: 15.sp, textColor: AppColors.textColor7A),
          AppText(text: "0$itemCount", fontSize: 15.sp, textColor: AppColors.textColorC0),
          10.horizontalSpace
        ],
      ),
      12.verticalSpace,
      AppText(text: item?.subTitle ?? "", fontSize: 21.sp, textColor: AppColors.textColor41),
      12.verticalSpace,
      AppText(
        text: item?.content ?? "",
        fontSize: 16.sp,
        textColor: AppColors.textColor9A,
        maxLines: 1,
      ),
      12.verticalSpace,
      Container(
          padding: EdgeInsets.only(right: 8.w),
          child: ClipRRect(
              borderRadius: BorderRadius.circular(8.r),
              child: Image.network(
                item?.imageUrl ?? "",
                height: 201.h,
                width: double.infinity,
                fit: BoxFit.fill,
              )))
    ]);
  }
}