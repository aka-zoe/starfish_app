import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'amap_location_platform_interface.dart';

/// An implementation of [AmapLocationPlatform] that uses method channels.
class MethodChannelAmapLocation extends AmapLocationPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('amap_location');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }
}
