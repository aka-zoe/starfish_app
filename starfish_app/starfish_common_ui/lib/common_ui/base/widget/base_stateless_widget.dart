import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import '../wt_event_manager.dart';
import '../listener/observer_app_listener.dart';
import '../listener/state_less_lifecycle.dart';

abstract class BaseStatelessWidget extends StatelessWidget
    with ObserverAppListener, StateLessLifecycle {
  BaseStatelessWidget({super.key});

  @override
  StatelessElement createElement() {
    onInit();
    return _BaseStateLessElement(this, this, this);
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

  ///组件初始化，build之前
  @mustCallSuper
  @override
  void onInit() {}

  ///组件销毁
  @mustCallSuper
  @override
  void onDestroy() {}
}

///无状态组件通过element注册观察者
class _BaseStateLessElement extends StatelessElement {
  final ObserverAppListener observer;
  final StateLessLifecycle lifecycle;

  _BaseStateLessElement(super.widget, this.observer, this.lifecycle);

  @override
  Widget build() {
    WTEventManager.instance.registerObserver(observer);
    return super.build();
  }

  @override
  void deactivate() {
    WTEventManager.instance.unregister(observer);
    lifecycle.onDestroy();
    super.deactivate();
  }
}
