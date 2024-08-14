import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:oktoast/oktoast.dart';
import 'package:provider/provider.dart';
import 'package:starfish_tenement_app/api/models/house_res_detail_data.dart';
import 'package:starfish_tenement_app/common_ui/app_bar/app_title_bar.dart';
import 'package:starfish_tenement_app/common_ui/buttons/red_button.dart';
import 'package:starfish_tenement_app/common_ui/date_selector/date_selector_widget.dart';
import 'package:starfish_tenement_app/common_ui/title/app_text.dart';
import 'package:starfish_tenement_app/common_ui/title/big_title.dart';
import 'package:starfish_tenement_app/pages/mine/booked/booked_house_vm.dart';
import 'package:starfish_tenement_app/route/route_utils.dart';
import 'package:starfish_tenement_app/styles/app_colors.dart';
import 'package:starfish_tenement_app/utils/string_utils.dart';

///房源预定页
class SubscribeHousePage extends StatefulWidget {
  final HouseResDetailData? detailData;

  const SubscribeHousePage({super.key, this.detailData});

  @override
  State createState() {
    return _SubscribeHousePageState();
  }
}

class _SubscribeHousePageState extends State<SubscribeHousePage> {
  final BookedHouseViewModel _viewModel = BookedHouseViewModel();

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider<BookedHouseViewModel>(
        create: (context) {
          return _viewModel;
        },
        child: Scaffold(
          backgroundColor: Colors.white,
          body: SafeArea(
              child: Column(
            children: [
              AppTitleBar(
                title: "房源预约",
              ),
              //顶部房源信息
              _totalHouseInfo(),
              //房源预约时间选择组件
              DateTimeSelector(builder: (date, time) {
                //时间选择的回调
                _viewModel.setSelectDate("$date $time");
              }),
              20.verticalSpace,
              BigTitle(bigTitle: "联系方式", padding: EdgeInsets.only(left: 20.w, bottom: 29.h)),
              //更改联系方式
              _changeContractInput(),
              //请填写真实姓名
              _inputRealName(),
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
                  onTap: () {
                    //提交预约记录
                    _viewModel
                        .submitBooked(
                            houseresid: widget.detailData?.id,
                            bookeduserid: widget.detailData?.publisherId)
                        .then((value) {
                      if (value == true) {
                        showToast("预约成功");
                        RouteUtils.pop(context);
                      }
                    });
                  },
                ),
                AppText(
                  text: "地址:${widget.detailData?.houseAreaAddress}",
                  fontSize: 13.sp,
                  textColor: const Color(0xFFafafac),
                )
              ],
            ),
          ),
        ));
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
                    //图片列表不为空就取第一张图，否则空字符串
                    ((widget.detailData?.imageList?.length ?? 0) > 0 == true)
                        ? (widget.detailData?.imageList?[0] ?? "")
                        : "",
                    width: 98.w,
                    height: 74.h,
                    fit: BoxFit.fill)),
            18.horizontalSpace,
            Expanded(
                child: Column(crossAxisAlignment: CrossAxisAlignment.start, children: [
              AppText(
                  text: StringUtils.limitString(
                      content: "${widget.detailData?.houseArea}${widget.detailData?.houseTypeName}",
                      limits: 11),
                  textColor: AppColors.textColor2b,
                  fontSize: 19.sp),
              AppText(
                  text: "${widget.detailData?.houseTypeName}${widget.detailData?.acreage}m²",
                  textColor: AppColors.textColorB6,
                  fontSize: 13.sp),
              Row(
                children: [
                  AppText(
                      text: "${widget.detailData?.rent}",
                      textColor: AppColors.textRedColor39,
                      fontSize: 18.sp),
                  AppText(text: "元/月", textColor: AppColors.textRedColor6d, fontSize: 11.sp),
                  Expanded(child: SizedBox()),
                  AppText(
                      text: "服务费：${widget.detailData?.serviceCharge}元",
                      textColor: AppColors.textColorB6,
                      fontSize: 14.sp),
                ],
              )
            ]))
          ],
        ));
  }

  ///更改联系方式
  Widget _changeContractInput() {
    return Consumer<BookedHouseViewModel>(
      builder: (context, vm, child) {
        return Container(
          margin: EdgeInsets.only(left: 20.w, right: 20.w),
          padding: EdgeInsets.only(left: 10.w, right: 10.w),
          height: 45.h,
          decoration: vm.editUserName
              //可输入时背景色变为灰色，否则背景不变
              ? BoxDecoration(
                  color: const Color(0xFFf8f8f8),
                  borderRadius: BorderRadius.all(Radius.circular(5.r)))
              : BoxDecoration(
                  border: Border(
                      top: BorderSide(color: Color(0xFFf7f7f6), width: 1.h),
                      bottom: BorderSide(color: Color(0xFFf7f7f6), width: 1.h))),
          child: Row(
            children: [
              Expanded(
                  child: TextField(
                controller: vm.phoneInputController,
                decoration: const InputDecoration(border: InputBorder.none),
                enabled: vm.editUserName,
              )),
              GestureDetector(
                  onTap: () {
                    vm.changeUserName();
                  },
                  child: AppText(text: "更改联系方式", textColor: Color(0xFFff3b3d), fontSize: 14.sp))
            ],
          ),
        );
      },
    );
  }

  ///请填写真实姓名
  Widget _inputRealName() {
    return Container(
      padding: EdgeInsets.only(left: 20.w, right: 20.w),
      decoration: BoxDecoration(
          color: const Color(0xFFf8f8f8), borderRadius: BorderRadius.all(Radius.circular(5.r))),
      height: 44.h,
      margin: EdgeInsets.all(20.h),
      child: TextField(
        controller: _viewModel.nameInputController,
        decoration: InputDecoration(
            hintStyle: TextStyle(color: Color(0xffcfcfcf), fontSize: 16.sp),
            hintText: "请填写真实姓名",
            border: InputBorder.none),
      ),
    );
  }
}
