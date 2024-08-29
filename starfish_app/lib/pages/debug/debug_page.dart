import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_common_ui/common_ui/app_bar/app_search_bar.dart';
import 'package:starfish_common_ui/common_ui/app_bar/app_title_bar.dart';
import 'package:starfish_common_ui/common_ui/buttons/red_button.dart';
import 'package:starfish_common_ui/common_ui/styles/app_colors.dart';

class DebugPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _DebugPageState();
  }
}

class _DebugPageState extends State<DebugPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: SafeArea(
      child: SingleChildScrollView(
          child: Expanded(
              child: Column(
        children: [

          AppTitleBar(title: "我是标题",),
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
          ),
          5.verticalSpace,
          //包含左边按钮的搜索框
          AppSearchBar(
            searchType: SearchType.square,
            showLeftMenu: true,
            leftMenu: Container(
              child: Row(
                children: [
                  Text("上海", style: TextStyle(color: AppColors.textColor3a)),
                  SizedBox(width: 5.w),
                  Image.asset("assets/images/icon_daosanjiao_shixin.png", width: 7.w, height: 5.h)
                ],
              ),
            ),
          ),
          10.verticalSpace,
          //圆角搜索框，包含右边icon按钮
          AppSearchBar(searchType: SearchType.circle, showRightIcon: true)
        ],
      ))),
    ));
  }
}
