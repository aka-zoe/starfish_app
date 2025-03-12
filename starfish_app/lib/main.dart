import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/settings.dart';
import 'package:starfish_utils/utils/push_utils.dart';
import 'package:starfish_http/http/dio_instance.dart';
import 'app.dart';

void main() async {
  DioInstance.instance().initDio(baseUrl: "https://fullstackpa.com");
  await ScreenUtil.ensureScreenSize();
  PushUtils.registerPush();
  if (kDebugMode && openDebugPage) {
    runApp(const DebugMyApp());
  } else {
    runApp(const MyApp());
  }
}
