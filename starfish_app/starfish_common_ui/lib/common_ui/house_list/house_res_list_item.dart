import 'package:flutter/cupertino.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import '../styles/app_colors.dart';
import '../tag/tag_widget.dart';
import '../title/app_text.dart';
import 'package:starfish_api/api/models/house_res_data.dart';

class HouseListItem extends StatelessWidget {
  const HouseListItem({super.key, this.onTap, this.data});

  final HouseResData? data;
  final GestureTapCallback? onTap;

  @override
  Widget build(BuildContext context) {
    //生成标签列表
    var tagList = generateTagList();
    return GestureDetector(onTap: onTap, child: _houseListItem(tagList));
  }

  ///房源列表item
  Widget _houseListItem(List<Widget> tagList) {
    return Container(
        //设置底部分割线
        decoration: BoxDecoration(
            border: Border(bottom: BorderSide(color: AppColors.lineColor, width: 1.r))),
        padding: EdgeInsets.symmetric(vertical: 21.h),
        width: double.infinity,
        child: Row(children: [
          Image.network(data?.image ?? "", width: 122.w, height: 96.h, fit: BoxFit.fill),
          SizedBox(width: 17.w),
          Expanded(
              child: Column(crossAxisAlignment: CrossAxisAlignment.start, children: [
            AppText(
              text: data?.title ?? "",
              textColor: AppColors.textColor2b,
              fontSize: 19.sp,
              maxLines: 2,
            ),
            AppText(text: data?.subTitle ?? "", textColor: AppColors.textColorB6, fontSize: 13.sp),
            //要给固定高度在column内，否则报错
            tagList.isEmpty
                ? const SizedBox()
                : SizedBox(
                    height: 30.h,
                    child: ListView(
                      scrollDirection: Axis.horizontal,
                      children: tagList,
                    )),
            Row(
              children: [
                AppText(
                    text: "${data?.rent}", textColor: AppColors.textRedColor39, fontSize: 19.sp),
                AppText(text: "元/月", textColor: AppColors.textRedColor6d, fontSize: 11.sp)
              ],
            )
          ]))
        ]));
  }

  ///生成标签列表
  List<Widget> generateTagList() {
    List<Widget> tagList = [];
    if (data?.tagList?.isEmpty == true) {
      return tagList;
    }
    data?.tagList?.forEach((tag) {
      //type 标签类型：0=hot
      tagList.add(TagWidget(
          name: tag.name ?? "在线签约", color: tag.type == "0" ? AppColors.textColorA9 : null));
      tagList.add(SizedBox(width: 10.w));
    });
    return tagList;
  }
}
