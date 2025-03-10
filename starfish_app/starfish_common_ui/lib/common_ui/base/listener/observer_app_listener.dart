import 'package:flutter/material.dart';

mixin class SupportAppListener {
  /// 语言切换
  void onLanguageChange(Locale local) {}

  /// 主题变化
  void onThemeChange(ThemeMode mode) {}
}

///APP全局类回调，观察者
mixin class ObserverAppListener implements SupportAppListener {
  /// 用户信息获取完成或者更新
  void onUserinfoUpdate(dynamic user) {}

  /// 退出登录
  void onLogout() {}

  @override
  void onLanguageChange(Locale local) {

  }

  @override
  void onThemeChange(ThemeMode mode) {

  }
}
