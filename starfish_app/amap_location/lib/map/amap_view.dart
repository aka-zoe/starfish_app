import 'package:amap_location/map/amap_constants.dart';
import 'package:amap_location/map/amap_controller.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

///高德地图组件：桥接原生版
class AMapView extends StatefulWidget {
  final AmapController? controller;

  const AMapView({super.key, this.controller});

  @override
  State<StatefulWidget> createState() {
    return _AMapViewState();
  }
}

class _AMapViewState extends State<AMapView> {
  AmapController? _controller;

  @override
  void initState() {
    super.initState();
    _controller ??= widget.controller ?? AmapController();
  }

  @override
  Widget build(BuildContext context) {
    return AndroidView(
        viewType: AMapConstants.Platform_AMap_viewTypeId,
        onPlatformViewCreated: (viewTypeId) {
          //初始化控制器
          var channelName = "${AMapConstants.Method_AMap_channelPath}$viewTypeId";
          _controller?.init(channelName);
        },
        creationParams: const <String, dynamic>{"key": "value"},
        creationParamsCodec: const StandardMessageCodec());
  }
}
