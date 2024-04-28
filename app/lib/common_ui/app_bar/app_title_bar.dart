import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

///通用的titleBar
class AppTitleBar extends StatelessWidget {
  const AppTitleBar(
      {super.key,
      this.rightIcon,
      this.title,
      this.backIcon,
      this.backgroundColor,
      this.onBackTap,
      this.onRightTap});

  //右边按钮图片路径
  final String? rightIcon;

  //标题
  final String? title;

  //左边返回按钮图片
  final String? backIcon;

  //整体背景色，默认白色
  final String? backgroundColor;

  //返回按钮事件
  final GestureTapCallback? onBackTap;

  //右边业务按钮事件
  final GestureTapCallback? onRightTap;

  @override
  Widget build(BuildContext context) {
    return SizedBox(
        width: double.infinity,
        height: 45.h,
        child: Row(mainAxisAlignment: MainAxisAlignment.spaceBetween, children: [
          GestureDetector(
              onTap: () {
                //默认点击即退出
                Navigator.pop(context);
                onBackTap?.call();
              },
              child: Container(
                alignment: Alignment.center,
                margin: EdgeInsets.only(left: 10.w),
                width: 40.r,
                height: 45.r,
                child: Image.asset(
                  "assets/images/icon_back_title.png",
                  width: 15.w,
                  height: 10.h,
                ),
              )),
          Text(title ?? "",
              style: TextStyle(fontSize: 16.sp, fontWeight: FontWeight.w500, color: Colors.black)),
          rightIcon == null
              ? GestureDetector(
                  onTap: onRightTap,
                  child: Container(
                      alignment: Alignment.center,
                      margin: EdgeInsets.only(right: 10.w),
                      height: 40.r,
                      width: 45.r,
                      child: Image.asset(rightIcon ?? "assets/images/icon_message.png",
                          height: 18.r, width: 18.r)))
              : const SizedBox()
        ]));
  }
}
