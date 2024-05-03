import 'package:flutter/cupertino.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/styles/app_colors.dart';

enum AppTextType {
  homeBigTitle,
}

///封装标题统一样式(目前项目中所有的Text显示都用了这个)
class AppText extends StatelessWidget {
  const AppText({
    super.key,
    required this.text,
    this.type,
    this.textColor,
    this.fontWeight,
    this.fontSize,
    this.maxLines,
    this.overflow,
  });

  final AppTextType? type;
  final String text;
  final Color? textColor;
  final FontWeight? fontWeight;
  final double? fontSize;
  final int? maxLines;
  final TextOverflow? overflow;

  @override
  Widget build(BuildContext context) {
    return Text(
      text,
      style: _style(),
      //最大行数
      maxLines: maxLines,
      //超出最大行数后结尾以省略号显示
      overflow: overflow ?? TextOverflow.ellipsis,
    );
  }

  TextStyle _style() {
    if (type == AppTextType.homeBigTitle) {
      return TextStyle(
          color: textColor ?? AppColors.titleColor3030,
          fontSize: fontSize ?? 18.sp,
          fontWeight: fontWeight ?? FontWeight.w600);
    } else {
      return TextStyle(color: textColor, fontSize: fontSize, fontWeight: fontWeight);
    }
  }
}
