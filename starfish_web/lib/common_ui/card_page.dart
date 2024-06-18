import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_web/route/route_utils.dart';
import 'package:starfish_web/route/routes.dart';

import '../styles/app_colors.dart';

///卡片布局
class CardPage extends StatelessWidget {
  final Widget child;
  final EdgeInsetsGeometry? padding;
  final EdgeInsetsGeometry? margin;
  final Radius? borderRadius;

  const CardPage({super.key, required this.child, this.padding, this.margin, this.borderRadius});

  @override
  Widget build(BuildContext context) {
    return cardPage(child, context, padding: padding, margin: margin, borderRadius: borderRadius);
  }

  //卡片布局
  Widget cardPage(Widget child, BuildContext context,
      {EdgeInsetsGeometry? padding, EdgeInsetsGeometry? margin, Radius? borderRadius}) {
    return Scaffold(
        backgroundColor: AppColors.transparent,
        body: SafeArea(
            child: Container(
                width: double.infinity,
                height: double.infinity,
                padding: padding ?? EdgeInsets.all(30.r),
                margin: margin ?? EdgeInsets.all(30.r),
                decoration: BoxDecoration(
                    color: AppColors.white,
                    borderRadius: BorderRadius.all(
                      borderRadius ?? Radius.circular(30.r),
                    )),
                child: Column(children: [
                  Container(
                      height: 50.h,
                      child: Row(children: [
                        Expanded(child: SizedBox()),
                        GestureDetector(
                            onTap: () {
                              RouteUtils.pushNamedAndRemoveUntil(context, RoutePath.login);
                            },
                            child: Text("注销", style: TextStyle(fontSize: 10.sp)))
                      ])),
                  Expanded(child: child)
                ]))));
  }
}
