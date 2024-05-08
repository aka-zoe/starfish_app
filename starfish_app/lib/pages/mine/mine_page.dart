import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/common_ui/title/app_title.dart';
import 'package:starfish_tenement_app/styles/app_colors.dart';

class MinePage extends StatefulWidget {
  @override
  State createState() {
    return _MinePageState();
  }
}

class _MinePageState extends State<MinePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Column(
          children: [
            Image.asset("assets/images/icon_mine_bg_01.png",
                height: 121.h, width: 220.w),
            // _header()
          ],
        ),
      ),
    );
  }

  Widget _header() {
    return Container(
        height: 121.h,
        child: Stack(
          children: [
            Padding(
                padding: EdgeInsets.only(right: 110.w),
                child: Image.asset("assets/images/icon_mine_bg_01.png",
                    height: double.infinity, width: double.infinity)),
            Padding(
                padding: EdgeInsets.only(right: 129.w),
                child: Image.asset("assets/images/icon_mine_bg_02.png",
                    height: double.infinity, width: double.infinity)),
            Padding(
                padding: EdgeInsets.only(left: 21.w, right: 21.w, bottom: 34.h),
                child: Row(
                  children: [
                    AppText(
                        text: "我的",
                        fontSize: 30.sp,
                        fontWeight: FontWeight.w600,
                        textColor: AppColors.textColor33),
                    Expanded(child: SizedBox()),
                    Image.asset("assets/images/icon_mine_lingdang.png", width: 21.w, height: 23.h)
                  ],
                ))
          ],
        ));
  }
}
