import 'dart:async';

import 'package:amap_location/map/amap_constants.dart';
import 'package:flutter/services.dart';

///地图控制器
class AmapController {
  MethodChannel? channel;

  ///初始化控制器
  void init(channelName) {
    channel = MethodChannel(channelName);
    //初始化，更新隐私政策，否则地图白屏
    channel?.invokeMethod(AMapConstants.Method_init);
  }

  ///[interval] 设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
  Future createMyLocation({num? interval}) async {
    return await channel?.invokeMethod("createMyLocation", {"interval": interval});
  }

  ///控制是否显示定位蓝点
  Future showMyLocation(bool visible) async {
    return await channel?.invokeMethod("showMyLocation", {"visible": visible});
  }
}
