import 'package:amap_location/map/amap_controller.dart';
import 'package:amap_location/map/amap_view.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class MapPage extends StatefulWidget {
  const MapPage({super.key});

  @override
  State createState() {
    return _MapPageState();
  }
}

class _MapPageState extends State<MapPage> {
  AmapController amapController = AmapController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: SafeArea(
            child: Stack(children: [
      _mapView(),
    ])));
  }

  Widget _mapView() {
    return Expanded(child: AMapView(controller: amapController));
  }
}
