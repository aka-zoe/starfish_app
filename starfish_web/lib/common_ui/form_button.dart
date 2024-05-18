import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

import '../styles/app_colors.dart';

///表单操作按钮
class FormButton extends StatefulWidget {
  final String? text;
  final VoidCallback? click;
  final double? fontSize;
  final Color? bgColor;

  FormButton({super.key, this.text, this.click, this.fontSize, this.bgColor});

  @override
  State createState() {
    return _FormButtonState();
  }
}

class _FormButtonState extends State<FormButton> {
  @override
  Widget build(BuildContext context) {
    return formButton(
        text: widget.text, click: widget.click, fontSize: widget.fontSize, bgColor: widget.bgColor);
  }

  //表单操作按钮
  Widget formButton({String? text, VoidCallback? click, double? fontSize, Color? bgColor}) {
    return ElevatedButton(
        style: ElevatedButton.styleFrom(
            padding: EdgeInsets.only(top: 30.h, bottom: 30.h, left: 10.w, right: 10.w),
            backgroundColor: bgColor ?? AppColors.buttonBg,
            foregroundColor: bgColor ?? AppColors.buttonBg,
            disabledBackgroundColor: bgColor ?? AppColors.buttonBg,
            disabledForegroundColor: bgColor ?? AppColors.buttonBg),
        onPressed: click,
        child:
            Text(text ?? "", style: TextStyle(color: AppColors.white, fontSize: fontSize ?? 8.sp)));
  }
}
