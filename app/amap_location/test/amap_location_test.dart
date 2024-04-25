import 'package:flutter_test/flutter_test.dart';
import 'package:amap_location/amap_location.dart';
import 'package:amap_location/amap_location_platform_interface.dart';
import 'package:amap_location/amap_location_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockAmapLocationPlatform
    with MockPlatformInterfaceMixin
    implements AmapLocationPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final AmapLocationPlatform initialPlatform = AmapLocationPlatform.instance;

  test('$MethodChannelAmapLocation is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelAmapLocation>());
  });

  test('getPlatformVersion', () async {
    AmapLocation amapLocationPlugin = AmapLocation();
    MockAmapLocationPlatform fakePlatform = MockAmapLocationPlatform();
    AmapLocationPlatform.instance = fakePlatform;

    expect(await amapLocationPlugin.getPlatformVersion(), '42');
  });
}
