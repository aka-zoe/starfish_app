import 'amap_location_platform_interface.dart';

class AmapLocation {
  AmapLocation._();

  static AmapLocation instance = AmapLocation._();

  ///设置高德APIkey
  Future<bool?> setApiKey({required String key}) {
    return AmapLocationPlatform.instance.setApiKey(key: key);
  }

  ///更新用户隐私政策
  Future<bool?> updatePrivacy() {
    return AmapLocationPlatform.instance.updatePrivacy();
  }

  ///初始化
  ///[interval]    定位间隔，默认2秒
  ///[httpTimeOut] 定位超时时间，默认30秒
  Future<bool?> initLocation({int? interval = 2000, int? httpTimeOut = 30000}) {
    return AmapLocationPlatform.instance.initLocation(interval: interval, httpTimeOut: httpTimeOut);
  }

  ///开启定位
  Future<bool?> startLocation() {
    return AmapLocationPlatform.instance.startLocation();
  }

  ///停止定位
  Future<bool?> stopLocation() {
    return AmapLocationPlatform.instance.stopLocation();
  }

  ///销毁定位
  Future<bool?> destroyLocation() {
    return AmapLocationPlatform.instance.destroyLocation();
  }

  ///注册event回调
  Future locationEventCallback(void Function(dynamic event)? onData,
      {Function? onError, void Function()? onDone, bool? cancelOnError}) async {
    AmapLocationPlatform.instance.locationEventCallback((event) {
      onData?.call(event);
      print(event);
    });
  }
}
