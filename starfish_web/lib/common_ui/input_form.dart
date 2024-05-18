import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

///表单输入框
class InputForm extends StatelessWidget {
  final String? text;
  final double? fontSize;
  final double? formHeight;
  final double? inputWidth;
  final ValueChanged<String>? onInputChanged;
  final TextEditingController? inputController;

  const InputForm(
      {super.key,
      this.text,
      this.fontSize,
      this.formHeight,
      this.inputWidth,
      this.onInputChanged,
      this.inputController});

  @override
  Widget build(BuildContext context) {
    return inputForm(
        text: text,
        fontSize: fontSize,
        formHeight: formHeight,
        inputWidth: inputWidth,
        onInputChanged: onInputChanged,
        inputController: inputController);
  }

  //表单输入框
  Widget inputForm(
      {String? text,
      double? fontSize,
      double? textWidth,
      double? formHeight,
      double? inputWidth,
      ValueChanged<String>? onInputChanged,
      TextEditingController? inputController}) {
    return SizedBox(
        height: formHeight ?? 80.h,
        child: Row(mainAxisAlignment: MainAxisAlignment.start, children: [
          SizedBox(
            width: textWidth ?? 50.w,
            child: Text(
              text ?? "请输入：",
              style: TextStyle(fontSize: fontSize ?? 8.sp),
            ),
          ),
          SizedBox(
              width: inputWidth ?? 200.w,
              child: TextField(
                controller: inputController,
                onChanged: onInputChanged,
                decoration: InputDecoration(
                  contentPadding: EdgeInsets.only(left: 5.w),
                  focusedBorder: const OutlineInputBorder(gapPadding: 1),
                  border: const OutlineInputBorder(gapPadding: 1),
                ),
              ))
        ]));
  }
}
