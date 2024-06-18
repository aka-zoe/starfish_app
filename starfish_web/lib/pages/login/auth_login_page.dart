import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:starfish_web/pages/login/auth_view_model.dart';

import '../../route/route_utils.dart';
import '../home/home_page.dart';

class LoginPage extends StatefulWidget {
  const LoginPage({super.key});

  @override
  State createState() {
    return _LoginPageState();
  }
}

class _LoginPageState extends State<LoginPage> {
  AuthViewModel viewModel = AuthViewModel();

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
        create: (context) {
          return viewModel;
        },
        child: Scaffold(
            body: Container(
                padding: EdgeInsets.only(left: 100.w, right: 100.w, top: 80.h, bottom: 80.h),
                child: Row(children: [
                  Expanded(
                      child: Container(
                          color: Colors.blue.shade50,
                          child: Center(
                              child: Column(
                                  mainAxisAlignment: MainAxisAlignment.center,
                                  children: [
                                    Container(width: 250.r, height: 150.r, color: Colors.red),
                                    SizedBox(height: 40.h),
                                    Container(width: 250.r, height: 150.r, color: Colors.blue),
                                    SizedBox(height: 40.h),
                                    Container(width: 250.r, height: 150.r, color: Colors.green)
                                  ])))),
                  // Right side with login form
                  Expanded(
                      child: Padding(
                          padding: EdgeInsets.all(32.r),
                          child: Column(
                              mainAxisAlignment: MainAxisAlignment.center,
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Text('欢迎',
                                    style: TextStyle(
                                        fontSize: 32.sp, fontWeight: FontWeight.bold)),
                                SizedBox(height: 8.h),
                                Text('来到海星租房后台管理系统', style: TextStyle(fontSize: 16.sp)),
                                SizedBox(height: 32.h),
                                TextField(
                                    controller: viewModel.inputUserName,
                                    decoration: const InputDecoration(
                                        labelText: '输入账号', border: OutlineInputBorder())),
                                SizedBox(height: 16.h),
                                TextField(
                                    controller: viewModel.inputPassword,
                                    decoration: const InputDecoration(
                                        labelText: '输入密码', border: OutlineInputBorder()),
                                    obscureText: true),
                                SizedBox(height: 16.h),
                                Row(
                                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                                    children: [
                                      Row(children: [
                                        Consumer<AuthViewModel>(builder: (context, vm, child) {
                                          return Checkbox(
                                              value: vm.rememberMe,
                                              onChanged: (value) {
                                                vm.setRemember(value ?? false);
                                              });
                                        }),
                                        Text('记住我')
                                      ]),
                                      TextButton(onPressed: () {}, child: Text('忘记密码?'))
                                    ]),
                                SizedBox(height: 32.h),
                                Row(children: [
                                  Expanded(
                                      child: ElevatedButton(
                                          onPressed: () {
                                            viewModel.login().then((value) {
                                              if (value) {
                                                RouteUtils.pushAndRemoveUntil(
                                                    context, const HomePage());
                                              }
                                            });
                                          },
                                          child: Text('登录')))
                                ])
                              ])))
                ]))));
  }
}
