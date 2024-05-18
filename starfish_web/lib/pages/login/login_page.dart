import 'dart:developer';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:starfish_web/styles/app_colors.dart';

import '../../common_ui/style/common_styles.dart';
import '../../route/route_utils.dart';
import '../home/home_page.dart';
import 'auth_view_model.dart';

class LoginPage extends StatefulWidget {
  const LoginPage({super.key});

  @override
  State<StatefulWidget> createState() {
    return _LoginPageState();
  }
}

class _LoginPageState extends State<LoginPage> {
  var model = AuthViewModel();

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
        create: (context) {
          return model;
        },
        child: Scaffold(
            body: Container(
                width: double.infinity,
                decoration: const BoxDecoration(
                    gradient:
                        LinearGradient(colors: [AppColors.loginBgColor1, AppColors.loginBgColor2])),
                alignment: Alignment.center,
                child: _loginWidget())));
  }

  Widget _loginWidget() {
    return Container(
        padding: EdgeInsets.only(top: 25.h, bottom: 25.h, left: 15.w, right: 15.w),
        decoration: BoxDecoration(
            color: Colors.white, borderRadius: BorderRadius.all(Radius.circular(15.r))),
        width: 200.w,
        child: Column(
            mainAxisSize: MainAxisSize.min,
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              commonInputText(
                  labelText: '输入账号',
                  onChanged: (value) {
                    model.inputUserName = value;
                  }),
              SizedBox(height: 15.h),
              commonInputText(
                  labelText: '输入密码',
                  obscureText: true,
                  onChanged: (value) {
                    model.inputPassword = value;
                  }),
              SizedBox(height: 45.h),
              loginButton("开始登录", onTap: () {
                log("${model.inputUserName}");
                log("${model.inputPassword}");
                // model.login().then((value) {
                //   if (value) {
                RouteUtils.pushAndRemoveUntil(context, const HomePage());
                //   }
                // });
              }),
              SizedBox(height: 15.h),
              GestureDetector(
                  onTap: () {
                    //点击进入到注册页面
                    // RouteUtils.push(context, const RegisterPage());
                  },
                  child: Text("注册", style:  TextStyle(color: AppColors.textColor5e, fontSize: 11
                      .sp)))
            ]));
  }

  Widget loginButton(String title, {GestureTapCallback? onTap}) {
    return GestureDetector(
        onTap: onTap,
        child: Container(
          alignment: Alignment.center,
          margin: EdgeInsets.symmetric(horizontal: 34.w),
          width: double.infinity,
          height: 75.h,
          decoration: BoxDecoration(
            color:  AppColors.redBtnColor,
              border: Border.all(color: AppColors.redBtnColor, width: 2.r),
              borderRadius: BorderRadius.all(Radius.circular(34.r))),
          child: Text(
            title,
            style:  TextStyle(color: Colors.white, fontSize: 13.sp),
          ),
        ));
  }


  TextField commonInputText(
      {TextEditingController? controller,
      required String labelText,
      ValueChanged<String>? onChanged,
      TextStyle? style,
      bool? obscureText,
      Color? cursorColor}) {
    return TextField(
        onChanged: onChanged,
        controller: controller,
        style: style ?? TextStyle(color: AppColors.textColor5e, fontSize: 14.sp),
        obscureText: obscureText ?? false,
        cursorHeight: 35.h,
        cursorColor: cursorColor ?? AppColors.textColor5e,
        decoration: InputDecoration(
            filled: true,
            fillColor: AppColors.lineColor,
            enabledBorder: noOutline(),
            focusedBorder: noOutline(),
            labelText: labelText,
            labelStyle: const TextStyle(color: AppColors.textColor5e)));
  }

  OutlineInputBorder noOutline() {
    return const OutlineInputBorder(borderSide: BorderSide(style: BorderStyle.none));
  }
}


