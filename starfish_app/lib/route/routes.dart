import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:starfish_tenement_app/pages/house_res/detail/house_res_detail_page.dart';
import 'package:starfish_tenement_app/pages/auth/auth_page.dart';
import 'package:starfish_tenement_app/pages/mine/about_us/about_us_page.dart';
import 'package:starfish_tenement_app/pages/mine/collect/my_collect_house_page.dart';
import 'package:starfish_tenement_app/pages/mine/collect/my_collect_news_page.dart';
import 'package:starfish_tenement_app/pages/mine/feedback/feedback_page.dart';
import 'package:starfish_tenement_app/pages/mine/settings/settings_page.dart';
import 'package:starfish_tenement_app/pages/news/news_type/news_type_page.dart';

import '../pages/apartment/apartment_page.dart';
import '../pages/mine/booked/booked_house_page.dart';
import '../pages/tab_page.dart';

///路由注册管理类
class Routes {
  static Route<dynamic> generateRoute(RouteSettings settings) {
    switch (settings.name) {
      //首页tab
      case RoutePath.tab:
        return pageRoute(const TabPage(), settings: settings);
      //资讯分类页
      case RoutePath.newsTypePage:
        return pageRoute(const NewsTypePage(), settings: settings);
      //登录页
      case RoutePath.auth:
        return pageRoute(const AuthPage(), settings: settings);
      //房源明细页
      case RoutePath.houseResourceDetailPage:
        return pageRoute(const HouseResDetailPage(), settings: settings);
      //品牌公寓页面
      case RoutePath.apartmentPage:
        return pageRoute(const ApartmentPage(), settings: settings);
      //房源预定页
      case RoutePath.subscribeHousePage:
        return pageRoute(SubscribeHousePage(), settings: settings);
      //房源收藏页
      case RoutePath.myCollectHousePage:
        return pageRoute(MyCollectHousePage(), settings: settings);
      //资讯收藏页
      case RoutePath.myCollectNewsPage:
        return pageRoute(MyCollectNewsPage(), settings: settings);
      //关于我们
      case RoutePath.aboutUsPage:
        return pageRoute(AboutUsPage(), settings: settings);
      //反馈页面
      case RoutePath.feedbackPage:
        return pageRoute(FeedbackPage(), settings: settings);
      //设置页面
      case RoutePath.settingsPage:
        return pageRoute(SettingsPage(), settings: settings);
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
  //首页tab
  static const String tab = "/";

  //登录/注册
  static const String auth = "/auth";

  //注册
  static const String register = "/register";

  //搜索页
  static const String search = "/search";

  //咨询页
  static const String newsListPage = "/newsListPage";

  //房源列表页
  static const String houseResourcePage = "/houseResourcePage";

  //房源明细页
  static const String houseResourceDetailPage = "/houseResourceDetailPage";

  //资讯分类页
  static const String newsTypePage = "/newsTypePage";

  //品牌公寓页
  static const String apartmentPage = "/apartmentPage";

  //房源预定页
  static const String subscribeHousePage = "/subscribeHousePage";

  //资讯收藏
  static const String myCollectNewsPage = "/myCollectNewsPage";

  //房源收藏
  static const String myCollectHousePage = "/myCollectHousePage";

  //关于我们
  static const String aboutUsPage = "/aboutUsPage";

  //反馈页面
  static const String feedbackPage = "/feedbackPage";

  //设置页面
  static const String settingsPage = "/settingsPage";
}
