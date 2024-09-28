import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/settings.dart';
import 'package:starfish_utils/utils/push_utils.dart';
import 'package:starfish_http/http/dio_instance.dart';
import 'app.dart';

void main() async{
  // DioInstance.instance().initDio(baseUrl: "http://192.168.31.34:9900/");
  DioInstance.instance().initDio(baseUrl: "http://192.168.3.32:9900/");
  await ScreenUtil.ensureScreenSize();
  PushUtils.registerPush();
  if(kDebugMode&& openDebugPage){
    runApp(const DebugMyApp());
  }else{
    runApp(const MyApp());
  }

}
