import 'package:amap_location/amap_location.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:starfish_tenement_app/common_ui/app_bar/app_search_bar.dart';
import 'package:starfish_tenement_app/common_ui/app_bar/app_title_bar.dart';
import 'package:starfish_tenement_app/common_ui/banner/home_banner_widget.dart';
import 'package:starfish_tenement_app/common_ui/buttons/red_button.dart';
import 'package:starfish_tenement_app/common_ui/icon_text/icon_text.dart';
import 'package:starfish_tenement_app/common_ui/title/app_title.dart';
import 'package:starfish_tenement_app/datas/home_banner_data.dart';
import 'package:starfish_tenement_app/pages/home/home_vm.dart';
import 'package:starfish_tenement_app/styles/app_colors.dart';

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
          child: Column(
            children: [
              //位置、搜索栏、扫码
              _titleBar(),
              22.verticalSpace,
              //banner轮播
              _banner(),
              21.verticalSpace,
              Row(
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
              ),
              Container(
                  padding: EdgeInsets.only(top: 21.h, bottom: 26.h, left: 16.w),
                  alignment: Alignment.centerLeft,
                  child: AppTitle(type: AppTitleType.homeBigTitle, title: "本期优选")),
            ],
          ),
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
                  padding: EdgeInsets.only(left: 14.w),
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
}
