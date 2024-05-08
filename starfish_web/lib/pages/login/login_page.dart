import 'dart:developer';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:starfish_web/styles/app_colors.dart';

import '../../common_ui/common_styles.dart';
import '../../route/route_utils.dart';
import '../tab_page.dart';
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
            backgroundColor: AppColors.whiteColor80,
            body: SafeArea(
                child: Container(
                    margin: EdgeInsets.symmetric(horizontal: 15.w),
                    alignment: Alignment.center,
                    child:  Column(mainAxisAlignment: MainAxisAlignment.center, children: [
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
                      outlineButton("开始登录", onTap: () {
                        log("${model.inputUserName}");
                        log("${model.inputPassword}");
                        // model.login().then((value) {
                        //   if (value) {
                            RouteUtils.pushAndRemoveUntil(context, const TabPage());
                        //   }
                        // });
                      }),
                      SizedBox(height: 15.h),
                      GestureDetector(
                          onTap: () {
                            //点击进入到注册页面
                            // RouteUtils.push(context, const RegisterPage());
                          },
                          child: Text("注册", style: titleTextStyle15))
                    ])))));
  }
}
