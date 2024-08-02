import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/settings.dart';
import 'package:starfish_tenement_app/utils/push_utils.dart';

import 'app.dart';
import 'http/dio_instance.dart';

void main() async{
  DioInstance.instance().initDio(baseUrl: "http://172.25.12.71:9900/");
  await ScreenUtil.ensureScreenSize();
  PushUtils.registerPush();
  if(kDebugMode&& openDebugPage){
    runApp(const DebugMyApp());
  }else{
    runApp(const MyApp());
  }

}
