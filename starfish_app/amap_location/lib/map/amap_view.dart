import 'package:amap_location/map/amap_constants.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/services.dart';

///高德地图组件：桥接原生版
class AMapView extends StatefulWidget {
  const AMapView({super.key});

  @override
  State<StatefulWidget> createState() {
    return _AMapViewState();
  }
}

class _AMapViewState extends State<AMapView> {
  MethodChannel? channel;

  @override
  Widget build(BuildContext context) {
    return AndroidView(
        viewType: AMapConstants.Platform_AMap_viewTypeId,
        onPlatformViewCreated: (viewTypeId) {
          var channelName = "${AMapConstants.Method_AMap_channelPath}$viewTypeId";
          channel = MethodChannel(channelName);
          channel?.invokeMethod("method");
        },
        creationParams: const <String, dynamic>{"key": "value"},
        creationParamsCodec: const StandardMessageCodec());
  }
}
