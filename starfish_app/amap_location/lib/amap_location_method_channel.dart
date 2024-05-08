import 'package:amap_location/location_constants.dart';
import 'package:flutter/services.dart';

import 'amap_location_platform_interface.dart';

/// An implementation of [AmapLocationPlatform] that uses method channels.
class MethodChannelAmapLocation extends AmapLocationPlatform {
  final methodChannel = const MethodChannel(LocationConstants.METHOD_NAME);
  final eventChannel = const EventChannel(LocationConstants.EVENT_NAME);

  ///初始化
  ///[interval]    定位间隔，默认2秒
  ///[httpTimeOut] 定位超时时间，默认30秒
  @override
  Future<bool?> initLocation({int? interval = 2000, int? httpTimeOut = 30000}) {
    return methodChannel.invokeMethod(
        LocationConstants.METHOD_INIT_LOCATION, {"interval": interval, "httpTimeOut": httpTimeOut});
  }

  ///开启定位
  @override
  Future<bool?> startLocation() {
    return methodChannel.invokeMethod(LocationConstants.METHOD_START_LOCATION);
  }

  ///停止定位
  @override
  Future<bool?> stopLocation() {
    return methodChannel.invokeMethod(LocationConstants.METHOD_STOP_LOCATION);
  }

  ///销毁定位
  @override
  Future<bool?> destroyLocation() {
    return methodChannel.invokeMethod(LocationConstants.METHOD_DESTROY_LOCATION);
  }

  ///注册event回调
  @override
  Future locationEventCallback(void Function(dynamic event)? onData,
      {Function? onError, void Function()? onDone, bool? cancelOnError}) async {
    eventChannel
        .receiveBroadcastStream()
        .listen(onData, onError: onError, onDone: onDone, cancelOnError: cancelOnError);
  }

  ///更新用户隐私政策
  @override
  Future<bool?> updatePrivacy() {
    return methodChannel.invokeMethod(LocationConstants.METHOD_UPDATE_PRIVACY);
  }
}
