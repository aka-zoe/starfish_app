import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:starfish_tenement_app/common_ui/title/app_text.dart';
import 'package:starfish_tenement_app/pages/mine/about_us/about_us_page.dart';
import 'package:starfish_tenement_app/pages/mine/booked/list/my_booked_list_page.dart';
import 'package:starfish_tenement_app/pages/mine/collect/my_collect_house_page.dart';
import 'package:starfish_tenement_app/pages/mine/collect/my_collect_news_page.dart';
import 'package:starfish_tenement_app/pages/mine/feedback/feedback_page.dart';
import 'package:starfish_tenement_app/pages/mine/mine_vm.dart';
import 'package:starfish_tenement_app/pages/mine/settings/settings_page.dart';
import 'package:starfish_tenement_app/route/route_utils.dart';
import 'package:starfish_tenement_app/styles/app_colors.dart';

class MinePage extends StatefulWidget {
  @override
  State createState() {
    return _MinePageState();
  }
}

class _MinePageState extends State<MinePage> {
  final MineViewModel _viewModel = MineViewModel();

  @override
  void initState() {
    super.initState();
    WidgetsBinding.instance.addPostFrameCallback((timeStamp) {
      _viewModel.getAppInfo();
    });
  }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider<MineViewModel>(
        create: (context) {
          return _viewModel;
        },
        child: Scaffold(
          body: SafeArea(
            child: SingleChildScrollView(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  _header(onMessageTap: () {}),
                  15.verticalSpace,
                  Padding(
                      padding: EdgeInsets.only(left: 20.w, right: 20.w),
                      child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          mainAxisAlignment: MainAxisAlignment.start,
                          children: [
                            AppText(
                              text: "房源管理",
                              textColor: const Color(0xFFb7b7b4),
                              fontSize: 14.sp,
                            ),
                            Consumer<MineViewModel>(builder: (context, vm, child) {
                              return _mineItemWidget(
                                  title: "预约中心",
                                  subtitle: "已预约${vm.infoData?.bookedCount ?? 0}家",
                                  subTitleColor: AppColors.textColor62,
                                  showBottomLine: true,
                                  onItemTap: () {
                                    RouteUtils.push(context, const MyBookedListPage());
                                  });
                            }),
                            Consumer<MineViewModel>(builder: (context, vm, child) {
                              return _mineItemWidget(
                                  title: "房源收藏",
                                  subtitle: "已收藏${vm.infoData?.collectHouseCount ?? 0}套",
                                  subTitleColor: AppColors.textColorAE,
                                  showBottomLine: true,
                                  onItemTap: () {
                                    RouteUtils.push(context, const MyCollectHousePage());
                                  });
                            }),
                            Consumer<MineViewModel>(builder: (context, vm, child) {
                              return _mineItemWidget(
                                  title: "资讯收藏",
                                  onItemTap: () {
                                    RouteUtils.push(context, const MyCollectNewsPage());
                                  });
                            }),
                            AppText(
                              text: "通知管理",
                              textColor: const Color(0xFFb7b7b4),
                              fontSize: 14.sp,
                            ),
                            Consumer<MineViewModel>(builder: (context, vm, child) {
                              return _mineItemWidget(
                                  title: "消息中心",
                                  showSwitch: true,
                                  switchValue: vm.infoData?.openMsg,
                                  switchCallback: (value) {
                                    //是否开启消息事件
                                    vm.setOpenMsg(value);
                                  });
                            }),
                            AppText(
                              text: "其它",
                              textColor: const Color(0xFFb7b7b4),
                              fontSize: 14.sp,
                            ),
                            _mineItemWidget(
                                title: "意见反馈",
                                showBottomLine: true,
                                onItemTap: () {
                                  RouteUtils.push(context, FeedbackPage());
                                }),
                            _mineItemWidget(
                                title: "关于我们",
                                showBottomLine: true,
                                onItemTap: () {
                                  RouteUtils.push(context, AboutUsPage());
                                }),
                            _mineItemWidget(
                                title: "设置",
                                onItemTap: () {
                                  RouteUtils.push(context, SettingsPage());
                                }),
                          ]))
                ],
              ),
            ),
          ),
        ));
  }

  ///头布局
  Widget _header({GestureTapCallback? onMessageTap}) {
    return SizedBox(
        width: double.infinity,
        height: 121.h,
        child: Stack(children: [
          //红色背景色块
          Container(
              width: double.infinity,
              height: 121.h,
              padding: EdgeInsets.only(right: 110.w),
              child: Stack(
                children: [
                  Image.asset("assets/images/icon_mine_bg_01.png",
                      fit: BoxFit.fill, height: double.infinity, width: double.infinity),
                  Padding(
                      padding: EdgeInsets.only(right: 19.w),
                      child: Image.asset("assets/images/icon_mine_bg_02.png",
                          fit: BoxFit.fill, height: double.infinity, width: double.infinity))
                ],
              )),
          //文字和消息按钮
          Column(children: [
            const Expanded(child: SizedBox()),
            Row(
              children: [
                21.horizontalSpace,
                AppText(
                    text: "我的",
                    fontSize: 30.sp,
                    fontWeight: FontWeight.w600,
                    textColor: AppColors.textColor33),
                const Expanded(child: SizedBox()),
                GestureDetector(
                    onTap: onMessageTap,
                    child: Image.asset("assets/images/icon_mine_lingdang.png",
                        width: 21.w, height: 23.h)),
                21.horizontalSpace
              ],
            ),
            34.verticalSpace,
          ]),
        ]));
  }

  Widget _mineItemWidget(
      {String? title,
      String? subtitle,
      Color? subTitleColor,
      bool? showSwitch,
      bool? switchValue,
      ValueChanged<bool>? switchCallback,
      GestureTapCallback? onItemTap,
      bool? showBottomLine}) {
    return GestureDetector(
        onTap: onItemTap,
        child: Container(
          decoration: showBottomLine == true
              ? BoxDecoration(
                  border: Border(bottom: BorderSide(color: AppColors.textColorF6, width: 1.h)))
              : null,
          padding: EdgeInsets.only(top: 23.h, bottom: 23.h),
          child: Row(
            children: [
              //标题
              AppText(text: title ?? "", textColor: AppColors.textColor40, fontSize: 18.sp),
              const Expanded(child: SizedBox()),
              //副标题，为空就不显示
              AppText(text: subtitle ?? "", textColor: subTitleColor, fontSize: 16.sp),
              11.horizontalSpace,

              //是否显示开关组件还是箭头组件
              showSwitch == true
                  ? CupertinoSwitch(
                      value: switchValue ?? false,
                      onChanged: switchCallback,
                      activeColor: const Color(0xffeaeaec),
                      trackColor: const Color(0xffeaeaec),
                      thumbColor: Colors.white,
                    )
                  : Image.asset("assets/images/icon_right_arrow_grey.png",
                      width: 7.w, height: 13.h, fit: BoxFit.fill)
            ],
          ),
        ));
  }
}
