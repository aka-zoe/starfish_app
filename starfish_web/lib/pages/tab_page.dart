import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_web/common_ui/title/app_title.dart';
import 'package:starfish_web/styles/app_colors.dart';

import '../common_ui/expand_widget.dart';

class TabPage extends StatefulWidget {
  const TabPage({super.key});

  @override
  State<StatefulWidget> createState() {
    return _TabPageState();
  }
}

class _TabPageState extends State<TabPage> {
  ///State生命周期，在组件渲染前回调
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Colors.white,
        appBar: null,
        body: SafeArea(
            child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            //头布局
            _header(),
            Expanded(child: Row(
              children: [
                _tableMenuList(),
                _contentWidget()
              ],
            ))
          ],
        )));
  }

  //头布局
  Widget _header() {
    return Container(
        color: AppColors.cursorColor,
        width: double.infinity,
        height: 100.h,
        child: Row(children: [
          20.horizontalSpace,
          AppText(text: "海星租房", fontSize: 13.sp),
          ExpandWidget(),
          ClipRRect(
              child: Image.asset(
                "assets/images/head.png",
                height: 60.r,
                width: 60.r,
              ),
              borderRadius: BorderRadius.circular(30.r)),
          20.horizontalSpace
        ]));
  }

  //左边菜单布局
  Widget _tableMenuList() {
    return Expanded(
        flex: 1,
        child: SingleChildScrollView(
          child: Column(
            children: [],
          ),
        ));
  }

  //右边业务页面
  Widget _contentWidget(){
    return Expanded(
        flex: 5,
        child: Container(color: Colors.grey,));
  }
}
