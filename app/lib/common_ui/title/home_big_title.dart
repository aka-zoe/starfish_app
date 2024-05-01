import 'package:flutter/cupertino.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

import '../../styles/app_colors.dart';
import 'app_title.dart';

///大标题组件
class HomeBigTitle extends StatelessWidget {
  final String? bigTitle;
  final bool? showRight;
  final GestureTapCallback? onRightTap;

  const HomeBigTitle({super.key, this.bigTitle, this.showRight, this.onRightTap});

  @override
  Widget build(BuildContext context) {
    var title = AppTitle(type: AppTitleType.homeBigTitle, title: bigTitle ?? "");

    return Container(
        padding: EdgeInsets.only(top: 21.h, bottom: 26.h),
        alignment: Alignment.centerLeft,
        child: showRight == true
            ? Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  title,
                  const Expanded(child: SizedBox()),
                  GestureDetector(
                      onTap: onRightTap,
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          AppTitle(
                            title: "更多",
                            fontSize: 14.sp,
                            titleColor: AppColors.textColor7d,
                          ),
                          SizedBox(width: 6.w),
                          Image.asset("assets/images/icon_right_arrow_grey.png",
                              width: 6.w, height: 11.h)
                        ],
                      ))
                ],
              )
            : title);
  }
}
