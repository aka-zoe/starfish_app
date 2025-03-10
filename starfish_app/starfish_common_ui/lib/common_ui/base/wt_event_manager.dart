import 'package:flutter/material.dart';

import 'listener/observer_app_listener.dart';

///全局事件管理器
///1、管理观察者与回调事件的分发
///2、事件观察者注册与注销
class WTEventManager {
  WTEventManager._();

  static final WTEventManager instance = WTEventManager._();

  //观察者集合，保存所有的观察者对象
  final List<ObserverAppListener> _listeners = [];

  ///添加观察者
  void registerObserver(ObserverAppListener observer) {
    _listeners.add(observer);
  }

  ///用户信息获取完成或者更新
  void setUserinfoUpdate(dynamic user) {
    if (user == null) return;
    for (var observer in _listeners) {
      observer.onUserinfoUpdate(user);
    }
  }

  ///退出登录
  void setLogout() {
    for (var observer in _listeners) {
      observer.onLogout();
    }
  }

  ///当前语言切换
  void setLanguageChange(Locale? local) {
    if (local == null) return;
    for (var observer in _listeners) {
      observer.onLanguageChange(local);
    }
  }

  ///主题变化
  void setThemeChange(ThemeMode? mode) {
    if (mode == null) return;
    for (var observer in _listeners) {
      observer.onThemeChange(mode);
    }
  }

  ///注销观察者
  void unregister(ObserverAppListener observer) {
    if (_listeners.contains(observer)) {
      _listeners.remove(observer);
    }
  }
}
