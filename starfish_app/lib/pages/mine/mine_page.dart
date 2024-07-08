import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/common_ui/title/app_text.dart';
import 'package:starfish_tenement_app/pages/login/login_page.dart';
import 'package:starfish_tenement_app/route/route_utils.dart';
import 'package:starfish_tenement_app/styles/app_colors.dart';

class MinePage extends StatefulWidget {
  @override
  State createState() {
    return _MinePageState();
  }
}

class _MinePageState extends State<MinePage> {
  bool switchValue = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          mainAxisAlignment: MainAxisAlignment.start,
          children: [
            _header(onMessageTap: (){
              RouteUtils.push(context, LoginPage());
            }),
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
                      _mineItemWidget(
                          title: "预约中心",
                          subtitle: "已预约2家",
                          subTitleColor: AppColors.textColor62,
                          showBottomLine: true,
                          onItemTap: () {}),
                      _mineItemWidget(
                          title: "房源收藏",
                          subtitle: "已收藏4套",
                          subTitleColor: AppColors.textColorAE,
                          showBottomLine: true),
                      _mineItemWidget(title: "资讯收藏", onItemTap: () {}),
                      AppText(
                        text: "通知管理",
                        textColor: const Color(0xFFb7b7b4),
                        fontSize: 14.sp,
                      ),
                      _mineItemWidget(
                          title: "消息中心",
                          showSwitch: true,
                          switchValue: switchValue,
                          switchCallback: (value) {
                            switchValue = value;
                            setState(() {});
                          }),
                      AppText(
                        text: "其它",
                        textColor: const Color(0xFFb7b7b4),
                        fontSize: 14.sp,
                      ),
                      _mineItemWidget(title: "意见反馈", showBottomLine: true, onItemTap: () {}),
                      _mineItemWidget(title: "关于我们", showBottomLine: true, onItemTap: () {}),
                      _mineItemWidget(title: "设置", onItemTap: () {}),
                    ]))
          ],
        ),
      ),
    );
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
