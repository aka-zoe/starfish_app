import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

import 'app.dart';
import 'http/dio_instance.dart';

void main() async {
  DioInstance.instance().initDio(baseUrl: "http://192.168.3.4:9900/");
  await ScreenUtil.ensureScreenSize();
  runApp(const MyApp());
}
