import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

import '../styles/app_colors.dart';

//搜索栏样式
enum SearchType {
  //方形
  square,
  //圆角
  circle
}

class AppSearchBar extends StatelessWidget {
  AppSearchBar(
      {super.key,
      required this.searchType,
      this.controller,
      this.onChanged,
      this.showRightIcon,
      this.showLeftMenu,
      this.leftMenu,
      this.rightIcon,
      this.onRightIconTap,
      this.margin,
      this.rightIconPadding, this.hintText});

  TextEditingController? controller;
  final ValueChanged<String>? onChanged;

  //只有两种样式，圆角和方形
  final SearchType searchType;

  //是否显示右边icon按钮
  final bool? showRightIcon;

  //是否显示左边操作按钮
  final bool? showLeftMenu;

  //左边操作按钮
  final Widget? leftMenu;

  //右边icon按钮
  final Widget? rightIcon;

  //右边icon按钮点击事件
  final GestureTapCallback? onRightIconTap;

  final EdgeInsetsGeometry? margin;
  final EdgeInsetsGeometry? rightIconPadding;
  final String? hintText;

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        Expanded(
            child: Container(
                alignment: Alignment.center,
                padding: EdgeInsets.only(left: _getPaddingLeft()),
                margin: margin ?? EdgeInsets.only(left: 15.w, right: 15.w),
                height: 36.h,
                decoration: BoxDecoration(
                    color: AppColors.searchBgColor,
                    borderRadius:
                        searchType == SearchType.circle ? BorderRadius.circular(18.r) : null),
                child: Row(
                  children: [
                    //左边操作按钮
                    _leftMenu(),
                    Expanded(child: _searchInput())
                  ],
                ))),
        _rightIcon()
      ],
    );
  }

  ///搜索框
  Widget _searchInput() {
    controller ??= TextEditingController(text: "");
    //光标始终
    controller?.selection =
        TextSelection.fromPosition(TextPosition(offset: (controller?.text.length ?? 0)));
    return TextField(
      controller: controller,
      onChanged: onChanged,
      //定义光标的颜色和样式
      cursorColor: AppColors.cursorColor,
      // cursorHeight: 18.h,
      // cursorWidth: 2.r,
      // cursorRadius: Radius.circular(1.r),
      //文字方向
      textAlign: TextAlign.start,
      //装饰器
      decoration: InputDecoration(
        //前缀icon与样式,这里最大宽度给24是因为加上了内边距的10，否则icon会变小
        prefixIconConstraints: BoxConstraints(maxHeight: 14.r, maxWidth: 24.r),
        prefixIcon: Container(
            padding: EdgeInsets.only(right: 10.w),
            child: Image.asset("assets/images/icon_input_search.png", width: 14.r, height: 14.r)),

        // enabledBorder: _inputUnderline(),
        // focusedBorder: _inputUnderline(),
        // hintTextDirection: TextDirection.ltr,
        //输入内容上下居中并且去掉下划线
        contentPadding: EdgeInsets.all(0),
        border: OutlineInputBorder(borderSide: BorderSide.none),
        hintText: hintText ?? "寻找您的小窝~",
      ),
      textInputAction: TextInputAction.search,
    );
  }

  ///左边操作按钮
  Widget _leftMenu() {
    if (leftMenu == null || showLeftMenu != true) {
      return const SizedBox();
    }
    if (leftMenu != null) {
      return Row(children: [
        leftMenu!,
        //垂直灰色分割线
        Container(
            width: 1.w,
            height: 14.h,
            color: AppColors.verticalLimitColor,
            margin: EdgeInsets.only(left: 15.w, right: 15.w))
      ]);
    }
    return const SizedBox();
  }

  ///右边的icon按钮
  Widget _rightIcon() {
    if (showRightIcon != true && rightIcon == null) {
      return const SizedBox();
    }
    return GestureDetector(
        onTap: onRightIconTap,
        child: Container(
            padding: rightIconPadding ?? EdgeInsets.only(left: 10.w, right: 20.w),
            child: rightIcon ??
                Image.asset("assets/images/icon_message.png", width: 18.r, height: 18.r)));
  }

  ///透明化输入框下划线
  UnderlineInputBorder _inputUnderline() {
    return const UnderlineInputBorder(borderSide: BorderSide(color: Colors.transparent));
  }

  double _getPaddingLeft() {
    if (leftMenu == null || showLeftMenu != true) {
      return 24.w;
    } else {
      return 17.w;
    }
  }
}
