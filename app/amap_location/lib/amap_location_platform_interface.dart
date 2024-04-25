import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'amap_location_method_channel.dart';

abstract class AmapLocationPlatform extends PlatformInterface {
  /// Constructs a AmapLocationPlatform.
  AmapLocationPlatform() : super(token: _token);

  static final Object _token = Object();

  static AmapLocationPlatform _instance = MethodChannelAmapLocation();

  /// The default instance of [AmapLocationPlatform] to use.
  ///
  /// Defaults to [MethodChannelAmapLocation].
  static AmapLocationPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [AmapLocationPlatform] when
  /// they register themselves.
  static set instance(AmapLocationPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
