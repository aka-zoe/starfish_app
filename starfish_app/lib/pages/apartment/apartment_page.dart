import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/common_ui/app_bar/app_search_bar.dart';
import 'package:starfish_tenement_app/common_ui/title/app_text.dart';

import '../../common_ui/app_bar/app_title_bar.dart';
import '../../common_ui/filter/filter_menu_widget.dart';
import '../../common_ui/tag/tag_widget.dart';
import '../../styles/app_colors.dart';

///品牌公寓页面
class ApartmentPage extends StatefulWidget {
  const ApartmentPage({super.key});

  @override
  State createState() {
    return _ApartmentPageState();
  }
}

class _ApartmentPageState extends State<ApartmentPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Colors.white,
        body: SafeArea(
            child: Column(
          children: [
            AppTitleBar(title: "品牌公寓", onRightTap: () {}),
            //位置、搜索栏
            _locationSearchBar(),
            //筛选组件
            _filterArea(),
            //公寓列表
            _apartmentListWidget()
          ],
        )));
  }

  ///位置、搜索栏
  Widget _locationSearchBar() {
    return Container(
      padding: EdgeInsets.only(left: 20.w, top: 10.h, bottom: 10.h),
      width: double.infinity,
      child: Row(
        children: [
          //当前位置
          GestureDetector(
              onTap: () {
                //点击切换当前位置
              },
              child: Container(
                  child: Row(children: [
                Text("苏州", style: TextStyle(fontSize: 14.sp, color: AppColors.textColor5a)),
                4.horizontalSpace,
                Image.asset(
                  "assets/images/icon_daosanjiao.png",
                  width: 9.w,
                  height: 5.h,
                )
              ]))),
          //搜索栏
          Expanded(
              child: AppSearchBar(
            searchType: SearchType.square,
            showLeftMenu: false,
            showRightIcon: false,
          ))
        ],
      ),
    );
  }

  ///筛选条件区域
  Widget _filterArea() {
    return Container(
        decoration:
            BoxDecoration(border: Border(bottom: BorderSide(color: Color(0xFFF2F2F2), width: 1.h))),
        padding: EdgeInsets.only(left: 10.w, right: 10.w),
        child: Row(mainAxisAlignment: MainAxisAlignment.spaceBetween, children: [
          FilterMenuWidget(name: "推荐", selected: true, backgroundColor: Colors.transparent),
          FilterMenuWidget(name: "区域", backgroundColor: Colors.transparent),
          FilterMenuWidget(name: "租金", backgroundColor: Colors.transparent),
          FilterMenuWidget(name: "筛选", backgroundColor: Colors.transparent)
        ]));
  }

  ///公寓列表
  Widget _apartmentListWidget() {
    return Expanded(
        child: ListView.builder(
            itemCount: 10,
            itemBuilder: (context, index) {
              return _apartmentItem();
            }));
  }

  ///公寓item
  Widget _apartmentItem() {
    return Container(
        padding: EdgeInsets.only(top: 22.h, bottom: 12.h, left: 15.w, right: 15.w),
        child: Column(crossAxisAlignment: CrossAxisAlignment.start, children: [
          Container(
              height: 142.h,
              child: Row(children: [
                Expanded(
                    flex: 1,
                    child: Column(
                      children: [
                        Expanded(
                            flex: 1,
                            child: Image.network(
                                "https://n.sinaimg.cn/sinacn16/112/w1557h955/20180510/7270-haichqz7292785.jpg",
                                fit: BoxFit.fill)),
                        5.verticalSpace,
                        Expanded(
                            flex: 1,
                            child: Image.network(
                              "https://pic.616pic"
                              ".com/photoone/00/06/56/61975de20f1487757.jpg",
                              fit: BoxFit.fill,
                            ))
                      ],
                    )),
                7.horizontalSpace,
                Expanded(
                    flex: 3,
                    child: Image.network(
                        "https://pic.616pic.com/photoone/00/06/37/61975c8c74872813.jpg",
                        fit: BoxFit.fill)),
              ])),
          10.verticalSpace,
          AppText(
            text: "翻斗花园",
            fontSize: 21.sp,
            textColor: AppColors.textColor3a,
            fontWeight: FontWeight.w600,
          ),
          3.verticalSpace,
          AppText(
              text: "套一  50m2  距华府大道地铁站1.2km", fontSize: 12.sp, textColor: AppColors.textColorAd),
          3.verticalSpace,
          Row(
            children: [
              TagWidget(name: "在线签约", color: AppColors.textColorA9),
              SizedBox(width: 10.w),
              TagWidget(name: "近地铁"),
              SizedBox(width: 10.w),
              TagWidget(name: "精装修"),
              Expanded(child: SizedBox()),
              Row(
                mainAxisSize: MainAxisSize.min,
                children: [
                  AppText(text: "3000", textColor: AppColors.textRedColor39, fontSize: 19.sp),
                  AppText(text: "元/月", textColor: AppColors.textRedColor6d, fontSize: 11.sp)
                ],
              )
            ],
          )
        ]));
  }
}
