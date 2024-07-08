import 'package:flutter/cupertino.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

import '../../styles/app_colors.dart';
import 'app_text.dart';

///大标题组件
class BigTitle extends StatelessWidget {
  final String? bigTitle;
  final bool? showRight;
  final double? titleSize;
  final GestureTapCallback? onRightTap;
  final EdgeInsetsGeometry? padding;
  const BigTitle({super.key, this.bigTitle, this.showRight, this.onRightTap, this.titleSize, this.padding});

  @override
  Widget build(BuildContext context) {
    var title = AppText(
      type: AppTextType.homeBigTitle,
      text: bigTitle ?? "",
      fontSize: titleSize,
    );

    return Container(
        padding: padding ?? EdgeInsets.only(top: 21.h, bottom: 26.h),
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
                          AppText(
                            text: "更多",
                            fontSize: 14.sp,
                            textColor: AppColors.textColor7d,
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
