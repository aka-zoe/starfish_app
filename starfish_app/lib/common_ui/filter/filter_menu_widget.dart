import 'package:flutter/cupertino.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/common_ui/title/app_title.dart';
import 'package:starfish_tenement_app/styles/app_colors.dart';

///条件过滤菜单组件
class FilterMenuWidget extends StatefulWidget {
  final String? name;
  final bool? selected;
  final GestureTapCallback? onTap;
  final EdgeInsetsGeometry? padding;

  const FilterMenuWidget({super.key, this.name, this.selected, this.onTap, this.padding});

  @override
  State<StatefulWidget> createState() {
    return _FilterMenuWidgetState();
  }
}

class _FilterMenuWidgetState extends State<FilterMenuWidget> {
  @override
  Widget build(BuildContext context) {
    return GestureDetector(
        onTap: widget.onTap,
        child: Container(
          padding: EdgeInsets.only(left: 15.w, right: 17.w, top: 11.h, bottom: 11.h),
          color: AppColors.searchBgColor,
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              AppText(
                  text: widget.name ?? "",
                  fontSize: 16.sp,
                  textColor:
                      widget.selected == true ? AppColors.titleColor3030 : AppColors.textColorAd),
              SizedBox(width: 5.w),
              Image.asset(
                  widget.selected == true
                      ? "assets/images/icon_daosanjiao_shixin.png"
                      : "assets/images/icon_daosanjiao_shixin_grey.png",
                  width: 8.w,
                  height: 6.h)
            ],
          ),
        ));
  }
}
