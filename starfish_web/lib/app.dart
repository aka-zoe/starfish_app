import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:oktoast/oktoast.dart';
import 'package:starfish_web/route/route_utils.dart';
import 'package:starfish_web/route/routes.dart';

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    //toast提示必须为APP的顶层组件
    return OKToast(
        //屏幕适配父组件组件
        child: ScreenUtilInit(
      designSize: const Size(1080, 1920),
      builder: (context, child) {
        return MaterialApp(
          theme: ThemeData(
            tabBarTheme: TabBarTheme(dividerColor: Colors.transparent),
            useMaterial3: true,
          ),
          navigatorKey: RouteUtils.navigatorKey,
          onGenerateRoute: Routes.generateRoute,
          initialRoute: RoutePath.login,
        );
      },
    ));
  }
}

