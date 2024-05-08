import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:starfish_web/pages/login/login_page.dart';
import 'package:starfish_web/pages/login/register_page.dart';

import '../pages/tab_page.dart';

///路由注册管理类
class Routes {
  static Route<dynamic> generateRoute(RouteSettings settings) {
    switch (settings.name) {
      //登录
      case RoutePath.login:
        return pageRoute(const LoginPage(), settings: settings);
      //注册
      case RoutePath.register:
        return pageRoute(const RegisterPage(), settings: settings);
      //首页
      case RoutePath.tab:
        return pageRoute(const TabPage(), settings: settings);
    }
    return MaterialPageRoute(
        builder: (context) =>
            Scaffold(body: Center(child: Text('No route defined for ${settings.name}'))));
  }

  static MaterialPageRoute pageRoute(
    Widget page, {
    RouteSettings? settings,
    bool? fullscreenDialog,
    bool? maintainState,
    bool? allowSnapshotting,
  }) {
    return MaterialPageRoute(
        builder: (context) => page,
        settings: settings,
        fullscreenDialog: fullscreenDialog ?? false,
        maintainState: maintainState ?? true,
        allowSnapshotting: allowSnapshotting ?? true);
  }
}

///路由地址
class RoutePath {
  //登录
  static const String login = "/";

  //首页tab
  static const String tab = "/tab";

  //注册
  static const String register = "/register";

  //关于我们
  static const String about_us = "/about_us";

  //搜索页
  static const String search = "/search";

  //咨询页
  static const String newsListPage = "/newsListPage";

  //房源列表页
  static const String houseResourcePage = "/houseResourcePage";

  //资讯分类页
  static const String newsTypePage = "/newsTypePage";
}
