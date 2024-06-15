import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/common_ui/buttons/red_button.dart';
import 'package:starfish_tenement_app/common_ui/title/app_title.dart';
import 'package:starfish_tenement_app/pages/tab_page.dart';
import 'package:starfish_tenement_app/route/route_utils.dart';

///登录页
class LoginPage extends StatefulWidget {
  const LoginPage({super.key});

  @override
  State createState() {
    return _LoginPageState();
  }
}

class _LoginPageState extends State<LoginPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Stack(
      children: [
        //全屏背景图
        Image.asset(
          "assets/images/bg_login_image.png",
          width: double.infinity,
          height: double.infinity,
          fit: BoxFit.fill,
        ),
        //半透明黑色遮罩
        Container(width: double.infinity, height: double.infinity, color: const Color(0x50000000)),
        Padding(
            padding: EdgeInsets.only(left: 42.w, right: 42.w),
            child: Column(
              children: [
                SizedBox(
                  height: ScreenUtil().statusBarHeight + 51.h,
                ),
                AppText(
                  text: "朋友\n欢迎来到海星租房",
                  fontSize: 36.sp,
                  fontWeight: FontWeight.w800,
                  textColor: Colors.white,
                ),
                const Expanded(child: SizedBox()),
                Row(mainAxisAlignment: MainAxisAlignment.spaceAround, children: [
                  AppButton(
                    type: AppButtonType.red,
                    buttonText: "登录",
                    buttonWidth: 136.w,
                    buttonHeight: 46.h,
                    fontWeight: FontWeight.w600,
                    margin: EdgeInsets.zero,
                    onTap: () {
                      //开始登录
                    },
                  ),
                  AppButton(
                    type: AppButtonType.black,
                    buttonText: "注册",
                    buttonWidth: 136.w,
                    fontWeight: FontWeight.w600,
                    buttonHeight: 46.h,
                    margin: EdgeInsets.zero,
                    onTap: () {
                      //开始注册
                    },
                  ),
                ]),
                18.verticalSpace,
                Row(children: [
                  const Expanded(child: SizedBox()),
                  _justInButton(onTap: () {
                    //不登录，直接进入首页
                    RouteUtils.pushAndRemoveUntil(context, const TabPage());
                  }),
                ]),
                SizedBox(
                  height: ScreenUtil().bottomBarHeight + 52.h,
                )
              ],
            ))
      ],
    ));
  }

  ///直接进入
  Widget _justInButton({GestureTapCallback? onTap}) {
    return GestureDetector(
        onTap: onTap,
        child: Row(children: [
          AppText(
            text: "直接进入",
            fontSize: 14.sp,
            textColor: Colors.white,
            fontWeight: FontWeight.w600,
          ),
          3.horizontalSpace,
          Image.asset(
            "assets/images/icon_login_arrow.png",
            width: 17.w,
            height: 11.h,
          )
        ]));
  }
}
