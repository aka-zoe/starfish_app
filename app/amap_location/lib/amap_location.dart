
import 'amap_location_platform_interface.dart';

class AmapLocation {
  Future<String?> getPlatformVersion() {
    return AmapLocationPlatform.instance.getPlatformVersion();
  }
}
