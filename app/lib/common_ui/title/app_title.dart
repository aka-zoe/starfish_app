import 'package:flutter/cupertino.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/styles/app_colors.dart';

enum AppTitleType {
  homeBigTitle,
}

///封装标题统一样式
class AppTitle extends StatelessWidget {
  const AppTitle({
    super.key,
    required this.title,
    required this.type,
    this.titleColor,
    this.fontWeight,
    this.fontSize,
  });

  final AppTitleType type;
  final String title;
  final Color? titleColor;
  final FontWeight? fontWeight;
  final double? fontSize;

  @override
  Widget build(BuildContext context) {
    return Text(
      title,
      style: _style(),
    );
  }

  TextStyle _style() {
    if (type == AppTitleType.homeBigTitle) {
      return TextStyle(
          color: titleColor ?? AppColors.titleColor3030,
          fontSize: fontSize ?? 18.sp,
          fontWeight: fontWeight ?? FontWeight.w600);
    } else {
      return TextStyle(color: titleColor, fontSize: fontSize, fontWeight: fontWeight);
    }
  }
}
