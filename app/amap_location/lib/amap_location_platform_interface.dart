import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'amap_location_method_channel.dart';

abstract class AmapLocationPlatform extends PlatformInterface {
  AmapLocationPlatform() : super(token: _token);

  static final Object _token = Object();

  static AmapLocationPlatform _instance = MethodChannelAmapLocation();

  static AmapLocationPlatform get instance => _instance;

  static set instance(AmapLocationPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  ///初始化
  ///[interval]    定位间隔，默认2秒
  ///[httpTimeOut] 定位超时时间，默认30秒
  Future<bool?> initLocation({int? interval, int? httpTimeOut}) {
    throw UnimplementedError('initLocation() has not been implemented.');
  }

  ///开启定位
  Future<bool?> startLocation() {
    throw UnimplementedError('startLocation() has not been implemented.');
  }

  ///停止定位
  Future<bool?> stopLocation() {
    throw UnimplementedError('stopLocation() has not been implemented.');
  }

  ///销毁定位
  Future<bool?> destroyLocation() {
    throw UnimplementedError('destroyLocation() has not been implemented.');
  }

  ///注册event回调
  Future locationEventCallback(void Function(dynamic event)? onData,
      {Function? onError, void Function()? onDone, bool? cancelOnError})   {
    throw UnimplementedError('eventCallback() has not been implemented.');
  }
}
