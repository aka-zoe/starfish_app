import 'dart:convert';

import 'package:amap_location/amap_location.dart';
import 'package:flutter/cupertino.dart';

class Location {
  Location._();

  static Future initLocationSDK() async {
    await AmapLocation.instance.setApiKey(key: "e705eaaace29381df2fd225f6b3224cc");
    await AmapLocation.instance.updatePrivacy();
    await AmapLocation.instance.initLocation();
  }

  ///开启定位：查到定位信息后就停止定位，内部处理三次容错
  static Future startLocationOnce(ValueChanged locationCallback) async {
    int count = 0;
    AmapLocation.instance.startLocation();
    AmapLocation.instance.locationEventCallback((event) async {
      // print("定位：event=$event");
      dynamic location = event["event_callback_location"];
      var decode = json.decode(location);
      if (decode['e'] == null || decode['e'] == "") {
        count = count + 1;
        //三次后还拿不到就直接返回
        if (count == 3) {
          locationCallback.call(decode);
          //拿到定位信息后停止定位
          await AmapLocation.instance.stopLocation();
          await AmapLocation.instance.destroyLocation();
        }
      } else {
        locationCallback.call(decode);
        //拿到定位信息后停止定位
        await AmapLocation.instance.stopLocation();
        await AmapLocation.instance.destroyLocation();
      }
    });
  }

  ///开启定位，间隔2秒，轮询查
  static Future startLocation(ValueChanged locationCallback) async {
    AmapLocation.instance.startLocation();
    AmapLocation.instance.locationEventCallback((event) async {
      // print("定位：event=$event");
      dynamic location = event["event_callback_location"];
      var decode = json.decode(location);
      locationCallback.call(decode);
    });
  }

  static Future stopLocation() async {
    //停止定位要调用这两个方法
    await AmapLocation.instance.stopLocation();
    await AmapLocation.instance.destroyLocation();
  }
}
