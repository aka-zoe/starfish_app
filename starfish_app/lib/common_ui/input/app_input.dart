import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/styles/app_colors.dart';

class AppInput extends StatefulWidget {
  const AppInput(
      {super.key,
      this.controller,
      this.onChanged,
      this.hintText,
      this.keyboardType,
      this.obscureText});

  final TextEditingController? controller;
  final ValueChanged<String>? onChanged;
  final String? hintText;
  final TextInputType? keyboardType;
  final bool? obscureText;

  @override
  State createState() {
    return _AppInputState();
  }
}

class _AppInputState extends State<AppInput> {
  @override
  void initState() {
    super.initState();
    if (widget.controller != null) {
      //光标始终
      widget.controller?.selection =
          TextSelection.fromPosition(TextPosition(offset: (widget.controller?.text.length ?? 0)));
    }
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.only(left: 10.w),
      decoration:
          BoxDecoration(borderRadius: BorderRadius.all(Radius.circular(6.r)), color: Colors.white),
      child: TextField(
        controller: widget.controller,
        onChanged: widget.onChanged,
        obscureText: widget.obscureText ?? false,
        //定义光标的颜色和样式
        cursorColor: AppColors.cursorColor,
        // cursorHeight: 18.h,
        // cursorWidth: 2.r,
        // cursorRadius: Radius.circular(1.r),
        //文字方向
        textAlign: TextAlign.start,
        keyboardType: widget.keyboardType ?? TextInputType.text,
        //装饰器
        decoration: InputDecoration(
          enabledBorder: _inputUnderline(),
          focusedBorder: _inputUnderline(),
          // hintTextDirection: TextDirection.ltr,
          //输入内容上下居中并且去掉下划线
          border: const OutlineInputBorder(borderSide: BorderSide.none),
          hintText: widget.hintText ?? "请输入~",
        ),
        textInputAction: TextInputAction.done,
      ),
    );
  }

  ///透明化输入框下划线
  UnderlineInputBorder _inputUnderline() {
    return const UnderlineInputBorder(borderSide: BorderSide(color: Colors.transparent));
  }
}
