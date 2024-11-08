import 'dart:ui';

import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_web/styles/app_colors.dart';

//白色字体14号
TextStyle whiteTextStyle14 = TextStyle(color: Colors.white, fontSize: 14.sp);
//白色字体15号
TextStyle whiteTextStyle15 = TextStyle(color: Colors.white, fontSize: 15.sp);
//标题文本15号
TextStyle titleTextStyle15 = TextStyle(color: Colors.black, fontSize: 15.sp);
//黑色字体13号
TextStyle blackTextStyle13 = TextStyle(fontSize: 13.sp, color: Colors.black);
//普通字体，只做判空处理
Text normalText(String? text) {
  return Text(
    text ?? "",
    style: titleTextStyle15,
  );
}

TextField commonInputText(
    {TextEditingController? controller,
    required String labelText,
    ValueChanged<String>? onChanged,
    TextStyle? style,
    bool? obscureText,
    Color? cursorColor}) {
  return TextField(
      onChanged: onChanged,
      controller: controller,
      style: style ?? TextStyle(color: Colors.black, fontSize: 14.sp),
      obscureText: obscureText ?? false,
      cursorColor: cursorColor ?? Colors.black,
      decoration: InputDecoration(
          enabledBorder: commonOutLine(width: 2.r),
          focusedBorder: commonOutLine(width: 2.r),
          labelText: labelText,
          labelStyle: const TextStyle(color: Colors.black)));
}

OutlineInputBorder commonOutLine({double? width, Color? color}) {
  return OutlineInputBorder(
      borderSide: BorderSide(color: color ?? AppColors.redBtnColor, width: width ?? 2.r));
}

//白色边框白色字体按钮
Widget outlineButton(String title, {GestureTapCallback? onTap}) {
  return GestureDetector(
      onTap: onTap,
      child: Container(
        alignment: Alignment.center,
        margin: EdgeInsets.symmetric(horizontal: 20.w),
        width: double.infinity,
        height: 100.h,
        decoration: BoxDecoration(
            border: Border.all(color: AppColors.redBtnColor, width: 2.r),
            borderRadius: BorderRadius.all(Radius.circular(25.r))),
        child: Text(
          title,
          style: titleTextStyle15,
        ),
      ));
}
