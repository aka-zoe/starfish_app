import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/styles/app_colors.dart';

enum AppButtonType {
  //红色按钮
  red,
  //黑色按钮
  black,
  //红色圆角按钮
  redCorner
}

///APP通用按钮，包含APP所有按钮样式
class AppButton extends StatelessWidget {
  //按钮点击事件
  final GestureTapCallback? onTap;

  //按钮宽度
  final double? buttonWidth;

  //按钮高度
  final double? buttonHeight;

  //按钮边距，默认左右21.w
  final EdgeInsetsGeometry? margin;

  //按钮文字位置，默认居中
  final AlignmentGeometry? textAlignment;

  //按钮文字，默认“确定”
  final String? buttonText;

  //按钮文字样式，默认17.sp 白色
  final TextStyle? buttonTextStyle;

  final FontWeight? fontWeight;

  //按钮圆角度数
  final double? radius;

  //按钮类型，必填
  final AppButtonType type;

  const AppButton({
    super.key,
    required this.type,
    this.onTap,
    this.buttonWidth,
    this.buttonHeight,
    this.fontWeight,
    this.margin,
    this.textAlignment,
    this.buttonText,
    this.buttonTextStyle,
    this.radius,
  });

  @override
  Widget build(BuildContext context) {
    return InkWell(
        onTap: onTap,
        child: Container(
          decoration: BoxDecoration(
              borderRadius: (type == AppButtonType.redCorner)
                  ? BorderRadius.all(Radius.circular(radius ?? 24.r))
                  : null,
              color:
                  (type == AppButtonType.black) ? AppColors.blackColor333 : AppColors.redBtnColor),
          alignment: textAlignment ?? Alignment.center,
          width: buttonWidth ?? double.infinity,
          height: buttonHeight ?? 49.h,
          margin: margin ??
              EdgeInsets.only(
                left: 21.w,
                right: 20.w,
              ),
          child: Text(
            buttonText ?? "确定",
            style: buttonTextStyle ??
                TextStyle(
                    fontSize: 17.sp,
                    color: Colors.white,
                    fontWeight: fontWeight ?? FontWeight.w500),
          ),
        ));
  }
}
