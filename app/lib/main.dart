import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/settings.dart';

import 'app.dart';
import 'http/dio_instance.dart';

void main() async{
  DioInstance.instance().initDio(baseUrl: "https://www.wanandroid.com/");
  await ScreenUtil.ensureScreenSize();
  if(kDebugMode&& openDebugPage){
    runApp(const DebugMyApp());
  }else{
    runApp(const MyApp());
  }

}
