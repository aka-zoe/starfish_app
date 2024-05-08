import 'package:flutter/cupertino.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

import '../../styles/app_colors.dart';
import '../tag/tag_widget.dart';
import '../title/app_title.dart';

class HouseListItem extends StatelessWidget {
  const HouseListItem({super.key});

  @override
  Widget build(BuildContext context) {
    return _houseListItem();
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
            AppText(text: "翻斗花园二期主卧押一付三", textColor: AppColors.textColor2b, fontSize: 19.sp),
            AppText(
                text: "套二 50m2 距西二旗地铁站1.2km", textColor: AppColors.textColorB6, fontSize: 13.sp),
            Row(
              children: [
                TagWidget(name: "在线签约", color: AppColors.textColorA9),
                SizedBox(width: 10.w),
                TagWidget(name: "近地铁"),
                SizedBox(width: 10.w),
                TagWidget(name: "精装修"),
              ],
            ),
            Row(
              children: [
                AppText(text: "3000", textColor: AppColors.textRedColor39, fontSize: 19.sp),
                AppText(text: "元/月", textColor: AppColors.textRedColor6d, fontSize: 11.sp)
              ],
            )
          ]))
        ]));
  }
}
