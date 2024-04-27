import 'package:amap_location/amap_location.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/common_ui/app_bar/app_title_bar.dart';
import 'package:starfish_tenement_app/common_ui/buttons/red_button.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<StatefulWidget> createState() {
    return _HomePageState();
  }
}

class _HomePageState extends State<HomePage> {

  @override
  void initState() {
    super.initState();
    AmapLocation.instance.updatePrivacy().then((value){
      AmapLocation.instance.initLocation().then((value){
        AmapLocation.instance.startLocation();
        AmapLocation.instance.locationEventCallback((event) { });

      });
    });


  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: SafeArea(
      child: Column(
        children: [
          AppTitleBar(),
          5.verticalSpace,
          AppButton(type: AppButtonType.red, buttonText: "下一步"),
          5.verticalSpace,
          AppButton(
            type: AppButtonType.red,
            buttonText: "登录",
            buttonWidth: 200.w,
          ),
          5.verticalSpace,
          AppButton(type: AppButtonType.redCorner, buttonText: "立即预约"),
          5.verticalSpace,
          AppButton(
            type: AppButtonType.black,
            buttonWidth: 150.w,
            buttonText: "联系",
          )
        ],
      ),
    ));
  }
}
