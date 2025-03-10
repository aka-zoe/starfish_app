import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import '../listener/observer_app_listener.dart';
import '../wt_event_manager.dart';

/// 有状态组件 替换StatefulWidget
abstract class BaseStatefulWidget extends StatefulWidget {
  const BaseStatefulWidget({super.key});
}

/// 有状态组件 监听全局类数据更新回调方法，T 必须是BaseStatefulWidget的子类
abstract class BaseState<T extends BaseStatefulWidget> extends State<T> with ObserverAppListener {
  final baseStateKey = GlobalKey();

  @override
  void initState() {
    super.initState();
    // 注册回调监听
    WTEventManager.instance.registerObserver(this);
  }

  @override
  void dispose() {
    // 组件销毁之前也要注销观察者回调
    WTEventManager.instance.unregister(this);
    super.dispose();
  }

  ///当前语言切换
  @mustCallSuper
  @override
  void onLanguageChange(Locale local) {}

  ///主题变化
  @mustCallSuper
  @override
  void onThemeChange(ThemeMode mode) {}

  ///用户信息获取完成或者更新
  @mustCallSuper
  @override
  void onUserinfoUpdate(dynamic user) {}

  ///退出登录
  @mustCallSuper
  @override
  void onLogout() {}

}

// class TestPage extends BaseStatefulWidget {
//   const TestPage({super.key});
//
//   @override
//   State<StatefulWidget> createState() {
//     return _TestPage();
//   }
// }
//
// class _TestPage extends BaseState<TestPage> {
//   @override
//   Widget build(BuildContext context) {
//     return Container();
//   }
//
//   @override
//   void userInfoUpdate() {
//     super.userInfoUpdate();
//     print("_TestPage userInfoUpdate");
//   }
//
//   @override
//   void switchSystemSn() {
//     super.switchSystemSn();
//     print("_TestPage switchSystemSn");
//   }
//
//   @override
//   void logout() {
//     super.logout();
//     print("_TestPage logout");
//   }
//
//   @override
//   void languageChange() {
//     super.languageChange();
//     print("_TestPage languageChange");
//   }
// }
