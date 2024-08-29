import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:starfish_common_ui/common_ui/buttons/red_button.dart';
import 'package:starfish_common_ui/common_ui/title/app_text.dart';
import 'package:starfish_common_ui/common_ui/input/app_input.dart';
import 'package:starfish_route/route/route_path.dart';
import 'package:starfish_tenement_app/pages/auth/auth_vm.dart';
import 'package:starfish_tenement_app/pages/tab_page.dart';
import 'package:starfish_route/route/route_utils.dart';

///登录或者注册页
class AuthPage extends StatefulWidget {
  const AuthPage({super.key});

  @override
  State createState() {
    return _AuthPageState();
  }
}

class _AuthPageState extends State<AuthPage> with WidgetsBindingObserver {
  AuthViewModel viewModel = AuthViewModel();

  @override
  void initState() {
    super.initState();
    // WidgetsBinding.instance.addPostFrameCallback((timeStamp) {
    //   viewModel.checkAutoLogin().then((value) {
    //     if (value) {
    //       //登录成功，进入首页
    //       RouteUtils.pushNamedAndRemoveUntil(context, RoutePath.tab);
    //     }
    //   });
    // });

    /// 初始化
    WidgetsBinding.instance.addObserver(this);
  }

  @override
  void didChangeMetrics() {
    super.didChangeMetrics();
    WidgetsBinding.instance.addPostFrameCallback((_) {
      if (MediaQuery.of(context).viewInsets.bottom == 0) {
        //键盘收回
        if (viewModel.keyboardShow == false) {
          //防止重复刷新布局
          return;
        }
        viewModel.setKeyboardStatus(false);
      } else {
        //键盘弹出
        if (viewModel.keyboardShow) {
          //防止重复刷新布局
          return;
        }
        viewModel.setKeyboardStatus(true);
      }
    });
  }

  @override
  void dispose() {
    //销毁
    WidgetsBinding.instance.removeObserver(this);
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
        create: (context) {
          return viewModel;
        },
        child: Scaffold(
            body: Stack(children: [
          //全屏背景图
          Image.asset(
            "assets/images/bg_login_image.png",
            width: double.infinity,
            height: double.infinity,
            fit: BoxFit.fill,
          ),
          //半透明黑色遮罩
          Container(
              width: double.infinity, height: double.infinity, color: const Color(0x50000000)),
          Padding(
              padding: EdgeInsets.only(left: 42.w, right: 42.w),
              child: Column(children: [
                SizedBox(
                  height: ScreenUtil().statusBarHeight + 51.h,
                ),
                Selector<AuthViewModel, bool>(selector: (context, vm) {
                  return vm.keyboardShow;
                }, builder: (context, keyboardShow, child) {
                  return keyboardShow
                      ? const SizedBox()
                      : AppText(
                          text: "朋友\n欢迎来到海星租房",
                          fontSize: 30.sp,
                          fontWeight: FontWeight.w800,
                          textColor: Colors.white,
                        );
                }),
                Selector<AuthViewModel, int>(selector: (context, vm) {
                  return vm.uiType;
                }, builder: (context, uiType, child) {
                  if (uiType == 1) {
                    return _loginWidget();
                  } else if (uiType == 2) {
                    return _registerWidget();
                  } else {
                    return const Expanded(flex: 1, child: SizedBox());
                  }
                }),
                Selector<AuthViewModel, bool>(selector: (context, vm) {
                  return vm.keyboardShow;
                }, builder: (context, keyboardShow, child) {
                  return keyboardShow
                      ? const SizedBox()
                      : Row(mainAxisAlignment: MainAxisAlignment.spaceAround, children: [
                          AppButton(
                            type: AppButtonType.red,
                            buttonText: "登录",
                            buttonWidth: 136.w,
                            buttonHeight: 46.h,
                            fontWeight: FontWeight.w600,
                            margin: EdgeInsets.zero,
                            onTap: () {
                              //开始登录
                              viewModel.changeUi(1);
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
                              viewModel.changeUi(2);
                            },
                          ),
                        ]);
                }),
                18.verticalSpace,
                Selector<AuthViewModel, bool>(selector: (context, vm) {
                  return vm.keyboardShow;
                }, builder: (context, keyboardShow, child) {
                  return keyboardShow
                      ? const SizedBox()
                      : Row(children: [
                          const Expanded(child: SizedBox()),
                          //直接进入
                          _justInButton(onTap: () {
                            //不登录，直接进入首页
                            RouteUtils.pushAndRemoveUntil(context, const TabPage());
                          }),
                        ]);
                }),
                SizedBox(height: ScreenUtil().bottomBarHeight + 52.h)
              ]))
        ])));
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

  ///用户登录组件
  Widget _loginWidget() {
    //使用Expanded上下布局撑开
    return Expanded(
        child: Container(
      margin: EdgeInsets.only(left: 20.w, right: 20.w),
      child: Column(
        //所有内容垂直居中
        mainAxisAlignment: MainAxisAlignment.center,
        crossAxisAlignment: CrossAxisAlignment.end,
        children: [
          AppInput(controller: viewModel.inputName, hintText: "请输入账号"),
          10.verticalSpace,
          AppInput(controller: viewModel.inputPwd, hintText: "请输入密码", obscureText: true),
          10.verticalSpace,
          GestureDetector(
              onTap: () {
                FocusScope.of(context).unfocus();
                //开始登录
                viewModel.login(false).then((value) {
                  if (value) {
                    //登录成功，进入首页
                    RouteUtils.pushNamedAndRemoveUntil(context, RoutePath.tab);
                  }
                });
              },
              child: AppText(
                  text: "开始登录→",
                  fontWeight: FontWeight.w600,
                  textColor: Colors.white,
                  fontSize: 17.sp))
        ],
      ),
    ));
  }

  ///注册用户组件
  Widget _registerWidget() {
    //使用Expanded上下布局撑开
    return Expanded(
        child: Container(
      margin: EdgeInsets.only(left: 20.w, right: 20.w),
      child: Column(
        mainAxisSize: MainAxisSize.min,
        //所有内容垂直居中
        mainAxisAlignment: MainAxisAlignment.center,
        crossAxisAlignment: CrossAxisAlignment.end,
        children: [
          AppInput(controller: viewModel.inputName, hintText: "请输入账号"),
          10.verticalSpace,
          AppInput(controller: viewModel.inputPwd, hintText: "请输入密码", obscureText: true),
          10.verticalSpace,
          AppInput(controller: viewModel.inputRePwd, hintText: "请再次输入密码", obscureText: true),
          10.verticalSpace,
          GestureDetector(
              onTap: () {
                FocusScope.of(context).unfocus();
                viewModel.register();
              },
              child: AppText(
                  text: "确定注册→",
                  fontWeight: FontWeight.w600,
                  textColor: Colors.white,
                  fontSize: 17.sp))
        ],
      ),
    ));
  }
}
