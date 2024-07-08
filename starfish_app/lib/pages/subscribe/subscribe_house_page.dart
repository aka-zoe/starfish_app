import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/common_ui/app_bar/app_title_bar.dart';
import 'package:starfish_tenement_app/common_ui/buttons/red_button.dart';
import 'package:starfish_tenement_app/common_ui/date_selector/date_selector_widget.dart';
import 'package:starfish_tenement_app/common_ui/title/big_title.dart';
import 'package:starfish_tenement_app/utils/string_utils.dart';

import '../../common_ui/title/app_text.dart';
import '../../styles/app_colors.dart';

///房源预定页
class SubscribeHousePage extends StatefulWidget {
  const SubscribeHousePage({super.key});

  @override
  State createState() {
    return _SubscribeHousePageState();
  }
}

class _SubscribeHousePageState extends State<SubscribeHousePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
          child: Column(
        children: [
          AppTitleBar(
            title: "房源预约",
          ),
          //顶部房源信息
          _totalHouseInfo(),
          //房源预约时间选择组件
          DateTimeSelector(),
          20.verticalSpace,
          BigTitle(bigTitle: "联系方式", padding: EdgeInsets.only(left: 20.w, bottom: 29.h)),
          //更改联系方式
          _changeContractInput(
              TextEditingController(
                text: "13030363100",
              ),
              false),
          //请填写真实姓名
          _inputRealName(TextEditingController()),
        ],
      )),
      bottomNavigationBar: Container(
        height: 101.h + ScreenUtil().bottomBarHeight,
        decoration: BoxDecoration(color: Colors.white, boxShadow: [
          BoxShadow(
              color: Color(0x80d9d9d9), offset: Offset(0, 0.9), blurRadius: 5, spreadRadius: 2)
        ]),
        child: Column(
          children: [
            AppButton(
              type: AppButtonType.redCorner,
              buttonHeight: 49.h,
              margin: EdgeInsets.only(top: 16.h, bottom: 13.h, left: 21.w, right: 21.w),
              buttonText: "立即预约",
            ),
            AppText(
              text: "地址:北京市海淀区宋家庄地铁站B出口500米",
              fontSize: 13.sp,
              textColor: const Color(0xFFafafac),
            )
          ],
        ),
      ),
    );
  }

  ///顶部房源信息
  Widget _totalHouseInfo() {
    return Container(
        height: 114.h,
        width: double.infinity,
        padding: EdgeInsets.only(top: 19.h, bottom: 19.h, left: 15.w, right: 20.w),
        margin: EdgeInsets.all(20.r),
        decoration: BoxDecoration(
            color: Colors.white,
            borderRadius: BorderRadius.all(Radius.circular(8.r)),
            boxShadow: [
              BoxShadow(
                  color: Color(0x80d9d9d9), offset: Offset(0, 0.9), blurRadius: 5, spreadRadius: 2)
            ]),
        child: Row(
          children: [
            ClipRRect(
                borderRadius: BorderRadius.all(Radius.circular(4.r)),
                child: Image.network(
                    "https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg",
                    width: 98.w,
                    height: 74.h,
                    fit: BoxFit.fill)),
            18.horizontalSpace,
            Expanded(
                child: Column(crossAxisAlignment: CrossAxisAlignment.start, children: [
              AppText(
                  text: StringUtils.limitString(content: "翻斗花园二期主卧押一付三", limits: 11),
                  textColor: AppColors.textColor2b,
                  fontSize: 19.sp),
              AppText(text: "套二 50m2", textColor: AppColors.textColorB6, fontSize: 13.sp),
              Row(
                children: [
                  AppText(text: "3000", textColor: AppColors.textRedColor39, fontSize: 18.sp),
                  AppText(text: "元/月", textColor: AppColors.textRedColor6d, fontSize: 11.sp),
                  Expanded(child: SizedBox()),
                  AppText(text: "服务费：3000元", textColor: AppColors.textColorB6, fontSize: 14.sp),
                ],
              )
            ]))
          ],
        ));
  }

  ///更改联系方式
  Widget _changeContractInput(TextEditingController inputController, bool canChange) {
    return Container(
      margin: EdgeInsets.only(left: 20.w, right: 20.w),
      padding: EdgeInsets.only(left: 10.w, right: 10.w),
      height: 45.h,
      decoration: BoxDecoration(
          border: Border(
              top: BorderSide(color: Color(0xFFf7f7f6), width: 1.h),
              bottom: BorderSide(color: Color(0xFFf7f7f6), width: 1.h))),
      child: Row(
        children: [
          Expanded(
              child: TextField(
            controller: inputController,
            decoration: InputDecoration(border: InputBorder.none),
            enabled: canChange,
          )),
          GestureDetector(
              onTap: () {},
              child: AppText(text: "更改联系方式", textColor: Color(0xFFff3b3d), fontSize: 14.sp))
        ],
      ),
    );
  }

  ///请填写真实姓名
  Widget _inputRealName(
    TextEditingController inputController,
  ) {
    return Container(
      padding: EdgeInsets.only(left: 20.w, right: 20.w),
      decoration: BoxDecoration(
          color: const Color(0xFFf8f8f8), borderRadius: BorderRadius.all(Radius.circular(5.r))),
      height: 44.h,
      margin: EdgeInsets.all(20.h),
      child: TextField(
        controller: inputController,
        decoration: InputDecoration(
            hintStyle: TextStyle(color: Color(0xffcfcfcf), fontSize: 16.sp),
            hintText: "请填写真实姓名",
            border: InputBorder.none),
      ),
    );
  }
}
