import 'dart:math';

import 'package:amap_location/amap_location.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:starfish_tenement_app/common_ui/app_bar/app_search_bar.dart';
import 'package:starfish_tenement_app/common_ui/app_bar/app_title_bar.dart';
import 'package:starfish_tenement_app/common_ui/banner/home_banner_widget.dart';
import 'package:starfish_tenement_app/common_ui/buttons/red_button.dart';
import 'package:starfish_tenement_app/common_ui/house_list/house_res_list_item.dart';
import 'package:starfish_tenement_app/common_ui/icon_text/icon_text.dart';
import 'package:starfish_tenement_app/common_ui/sliver/sliver_header.dart';
import 'package:starfish_tenement_app/common_ui/tag/tag_widget.dart';
import 'package:starfish_tenement_app/common_ui/title/app_title.dart';
import 'package:starfish_tenement_app/datas/home_banner_data.dart';
import 'package:starfish_tenement_app/pages/home/home_vm.dart';
import 'package:starfish_tenement_app/styles/app_colors.dart';

import '../../common_ui/filter/filter_menu_widget.dart';
import '../../common_ui/house_list/house_res_list_widget.dart';
import '../../common_ui/sliver/sliver_app_bar_delegate.dart';
import '../../common_ui/title/home_big_title.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<StatefulWidget> createState() {
    return _HomePageState();
  }
}

class _HomePageState extends State<HomePage> {
  final HomeVM _homeVM = HomeVM();

  @override
  void initState() {
    super.initState();
    _homeVM.getHomeData();
    AmapLocation.instance.updatePrivacy().then((value) {
      AmapLocation.instance.initLocation().then((value) {
        AmapLocation.instance.startLocation();
        AmapLocation.instance.locationEventCallback((event) {});
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
        create: (context) {
          return _homeVM;
        },
        child: Scaffold(
            body: SafeArea(
          child: Padding(
              padding: EdgeInsets.only(left: 16.w, right: 15.w),
              child: CustomScrollView(slivers: [
                SliverToBoxAdapter(
                  child: Column(children: [
                    //位置、搜索栏、扫码
                    _titleBar(),
                    22.verticalSpace,
                    //banner轮播
                    _banner(),
                    21.verticalSpace,
                    //金刚位按钮
                    _jinGangView(),
                    HomeBigTitle(bigTitle: "本期优选"),
                    //本期优选
                    _betterChoice(),
                    HomeBigTitle(bigTitle: "周边推荐", showRight: true, onRightTap: () {}),
                    //地图缩略图占位
                    _mapView(),
                  ]),
                ),

                //吸顶布局
                SliverHeader(
                  children: [
                    HomeBigTitle(bigTitle: "精选好房"),
                    //筛选条件区域
                    _filterArea()
                  ],
                ),
                //房源列表
                SliverList(
                    delegate: SliverChildBuilderDelegate((context, index) {
                      return const HouseListItem();
                    }, childCount: 20)),
              ])),
        )));
  }

  ///位置、搜索栏、扫码
  Widget _titleBar() {
    return Container(
      padding: EdgeInsets.only(top: 18.h),
      width: double.infinity,
      child: Row(
        children: [
          //当前位置
          GestureDetector(
              onTap: () {
                //点击切换当前位置
              },
              child: Container(
                  child: Row(children: [
                Text("苏州", style: TextStyle(fontSize: 14.sp, color: AppColors.textColor5a)),
                4.horizontalSpace,
                Image.asset(
                  "assets/images/icon_daosanjiao.png",
                  width: 9.w,
                  height: 5.h,
                )
              ]))),
          //搜索栏
          Expanded(
              child: AppSearchBar(
            searchType: SearchType.square,
            showLeftMenu: false,
            //扫码按钮
            rightIcon: Image.asset("assets/images/icon_scan.png", width: 19.r, height: 19.r),
            onRightIconTap: () {
              //打开扫码
            },
          ))
        ],
      ),
    );
  }

  ///banner轮播
  Widget _banner() {
    return Selector<HomeVM, List<HomeBanner>?>(builder: (context, List<HomeBanner>? bList, child) {
      return BannerWidget(
          dotType: BannerDotType.circle,
          bannerData: _homeVM.generalBannerList(bList),
          bannerClick: (index) {
            //banner点击
          });
    }, selector: (context, vm) {
      return vm.banner;
    });
  }

  ///金刚位
  Widget _jinGangView() {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceAround,
      children: [
        IconText(
          text: "整租",
          iconSize: Size(30.w, 31.h),
          iconPath: "assets/images/icon_home_zhengzu.png",
          onTap: () {},
        ),
        IconText(
          text: "合租",
          iconSize: Size(30.w, 31.h),
          iconPath: "assets/images/icon_home_hezu.png",
          onTap: () {},
        ),
        IconText(
          text: "资讯",
          iconSize: Size(30.w, 31.h),
          iconPath: "assets/images/icon_home_zixun.png",
          onTap: () {},
        ),
        IconText(
          text: "新房源",
          iconSize: Size(30.w, 31.h),
          iconPath: "assets/images/icon_home_xinfangyuan.png",
          onTap: () {},
        )
      ],
    );
  }

  ///本期优选
  Widget _betterChoice() {
    return SizedBox(
        width: double.infinity,
        height: 172.h,
        child: Row(
          children: [
            _commonBetterChoiceView(
                height: 172.h,
                width: 172.w,
                imgHeight: 172.h,
                imgWidth: 172.w,
                imgPath: "https://images.pexels.com/photos/2501965/pexels-photo-2501965.jpeg",
                title: "精品装修",
                titleSize: 17.sp,
                subTitle: "舒适的环境",
                subTitleSize: 12.sp,
                subTitleColor: AppColors.textColor78),
            SizedBox(width: 9.w),
            Expanded(
                child: Column(
              children: [
                Expanded(
                  child: _commonBetterChoiceView(
                      height: 80.h,
                      imgHeight: 80.h,
                      imgWidth: double.infinity,
                      imgPath: "https://images.pexels.com/photos/101808/pexels-photo-101808.jpeg",
                      title: "温馨小窝",
                      titleSize: 17.sp,
                      subTitle: "惬意的生活",
                      subTitleSize: 12.sp,
                      titleColor: Colors.white,
                      subTitleColor: Colors.white,
                      textPadding: EdgeInsets.only(left: 16.w, top: 13.h),
                      titleWeight: FontWeight.w600),
                ),
                SizedBox(height: 11.w),
                Expanded(
                  child: _commonBetterChoiceView(
                      height: 80.h,
                      imgHeight: 80.h,
                      imgWidth: double.infinity,
                      imgPath: "https://images.pexels.com/photos/1396122/pexels-photo-1396122.jpeg",
                      title: "大牌商圈",
                      titleSize: 17.sp,
                      subTitle: "选择更多",
                      subTitleSize: 12.sp,
                      titleColor: Colors.white,
                      subTitleColor: Colors.white,
                      textPadding: EdgeInsets.only(left: 16.w, top: 13.h),
                      titleWeight: FontWeight.w600),
                ),
              ],
            ))
          ],
        ));
  }

  ///本期优选通用布局
  Widget _commonBetterChoiceView(
      {double? height,
      double? width,
      String? imgPath,
      double? imgHeight,
      double? imgWidth,
      EdgeInsetsGeometry? textPadding,
      String? title,
      String? subTitle,
      double? titleSize,
      double? subTitleSize,
      Color? titleColor,
      Color? subTitleColor,
      FontWeight? titleWeight,
      GestureTapCallback? onTap}) {
    return GestureDetector(
        onTap: onTap,
        child: SizedBox(
          height: height,
          width: width,
          child: Stack(
            children: [
              Image.network(
                imgPath ?? "https://images.pexels.com/photos/2501965/pexels-photo-2501965.jpeg",
                height: imgHeight,
                width: imgWidth,
                fit: BoxFit.fill,
              ),
              Container(
                  padding: textPadding ?? EdgeInsets.only(left: 14.w, top: 23.h),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      AppText(
                        text: title ?? "",
                        fontSize: titleSize ?? 17.sp,
                        textColor: titleColor,
                        fontWeight: titleWeight,
                      ),
                      AppText(
                        text: subTitle ?? "",
                        fontSize: subTitleSize ?? 12.sp,
                        textColor: subTitleColor ?? AppColors.textColor78,
                      )
                    ],
                  ))
            ],
          ),
        ));
  }

  ///首页的大标题组件
  Widget _homeBigTitle({String? bigTitle, bool? showRight, GestureTapCallback? onRightTap}) {
    var title = AppText(type: AppTextType.homeBigTitle, text: bigTitle ?? "");

    return Container(
        padding: EdgeInsets.only(top: 21.h, bottom: 26.h),
        alignment: Alignment.centerLeft,
        child: showRight == true
            ? Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  title,
                  const Expanded(child: SizedBox()),
                  GestureDetector(
                      onTap: onRightTap,
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          AppText(
                            text: "更多",
                            fontSize: 14.sp,
                            textColor: AppColors.textColor7d,
                          ),
                          SizedBox(width: 6.w),
                          Image.asset("assets/images/icon_right_arrow_grey.png",
                              width: 6.w, height: 11.h)
                        ],
                      ))
                ],
              )
            : title);
  }

  ///地图缩略图占位
  Widget _mapView() {
    return Container(
        color: Colors.grey,
        height: 162.h,
        width: double.infinity,
        alignment: Alignment.center,
        child: Text("地图缩略图占位"));
  }

  ///筛选条件区域
  Widget _filterArea() {
    return Row(mainAxisAlignment: MainAxisAlignment.spaceBetween, children: [
      FilterMenuWidget(name: "区域", selected: true),
      FilterMenuWidget(name: "租金"),
      FilterMenuWidget(name: "户型"),
      FilterMenuWidget(name: "筛选")
    ]);
  }
}
