import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

import '../../styles/app_colors.dart';
import '../tag/tag_widget.dart';
import '../title/app_title.dart';

class HouseResListWidget extends StatefulWidget {
  const HouseResListWidget({super.key, this.shrinkWrap, this.physics});

  final bool? shrinkWrap;
  final ScrollPhysics? physics;

  @override
  State<StatefulWidget> createState() {
    return _HouseResListWidgetState();
  }
}

class _HouseResListWidgetState extends State<HouseResListWidget> {
  @override
  Widget build(BuildContext context) {
    return _houseListView();
  }

  ///房源列表
  Widget _houseListView() {
    return ListView.builder(
      shrinkWrap: widget.shrinkWrap ?? false,
      physics: widget.physics,
      itemBuilder: (context, index) {
        return _houseListItem();
      },
      itemCount: 10,
    );
  }

  ///房源列表item
  Widget _houseListItem() {
    return Container(
        //设置底部分割线
        decoration: BoxDecoration(
            border: Border(bottom: BorderSide(color: AppColors.lineColor, width: 1.r))),
        padding: EdgeInsets.symmetric(vertical: 21.h),
        width: double.infinity,
        child: Row(children: [
          Image.network("https://images.pexels.com/photos/1457842/pexels-photo-1457842.jpeg",
              width: 122.w, height: 96.h, fit: BoxFit.fill),
          SizedBox(width: 17.w),
          Expanded(
              child: Column(crossAxisAlignment: CrossAxisAlignment.start, children: [
            AppTitle(title: "翻斗花园二期主卧押一付三", titleColor: AppColors.textColor2b, fontSize: 19.sp),
            AppTitle(
                title: "套二 50m2 距西二旗地铁站1.2km", titleColor: AppColors.textColorB6, fontSize: 13.sp),
            Row(
              children: [
                TagWidget(name: "在线签约", hot: true),
                SizedBox(width: 10.w),
                TagWidget(name: "近地铁", hot: false),
                SizedBox(width: 10.w),
                TagWidget(name: "精装修", hot: false),
              ],
            ),
            Row(
              children: [
                AppTitle(title: "3000", titleColor: AppColors.textRedColor39, fontSize: 19.sp),
                AppTitle(title: "元/月", titleColor: AppColors.textRedColor6d, fontSize: 11.sp)
              ],
            )
          ]))
        ]));
  }
}
