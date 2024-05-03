import 'package:flutter/cupertino.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/common_ui/title/app_title.dart';
import 'package:starfish_tenement_app/styles/app_colors.dart';

///item中的tag组件
class TagWidget extends StatelessWidget {
  final String? name;
  final Color? color;

  const TagWidget({super.key, this.name, this.color});

  @override
  Widget build(BuildContext context) {
    return Container(
      color: AppColors.searchBgColor,
      padding: EdgeInsets.symmetric(horizontal: 7.w, vertical: 2.h),
      child: AppText(
        text: name ?? "",
        textColor: color ?? AppColors.textColor86,
      ),
    );
  }
}
