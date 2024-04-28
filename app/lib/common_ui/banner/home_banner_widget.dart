import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter_swiper_view/flutter_swiper_view.dart';
import 'package:starfish_tenement_app/styles/app_colors.dart';

///banner指示器形状
enum BannerDotType {
  //圆形
  circle,
  //方形
  square
}

class BannerWidget extends StatefulWidget {
  const BannerWidget(
      {super.key,
      required this.bannerData,
      this.setRadius,
      this.dotType,
      this.bannerClick,
      this.bannerRadius, this.height});

  //banner数据列表
  final List<String?>? bannerData;

  //是否设置圆角
  final bool? setRadius;

  //圆角弧度
  final double? bannerRadius;

  //指示器样式，默认圆形白色
  final BannerDotType? dotType;

  final double? height;

  //点击事件
  final ValueChanged<int>? bannerClick;

  @override
  State<StatefulWidget> createState() {
    return _BannerWidgetState();
  }
}

class _BannerWidgetState extends State<BannerWidget> {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Container(
        width: double.infinity,
        height: widget.height ?? 181.h,
        margin: EdgeInsets.only(left: 19.w, right: 19.w),
        child: Swiper(
          indicatorLayout: PageIndicatorLayout.NONE,
          autoplayDelay: 5000,
          duration: 800,
          autoplay: true,
          pagination: _pagination(),
          autoplayDisableOnInteraction: false,
          onTap: (int index) {
            widget.bannerClick?.call(index);
          },
          itemBuilder: (BuildContext context, int index) {
            return ClipRRect(
                borderRadius: widget.dotType == BannerDotType.circle
                    ? BorderRadius.all(Radius.circular(5.r))
                    : BorderRadius.zero,
                child: CachedNetworkImage(
                    fit: BoxFit.fill,
                    placeholder: (context, url) {
                      return const Center(
                        //圆形进度条指示器
                        child: CircularProgressIndicator(color: AppColors.redBtnColor),
                      );
                    },
                    imageUrl: widget.bannerData?[index] ?? ""));
          },
          itemCount: widget.bannerData?.length ?? 0,
        ));
  }

  ///指示器样式，默认圆形白色
  SwiperPagination _pagination() {
    if (widget.dotType == BannerDotType.square) {
      //方形红色
      return SwiperPagination(
          margin: EdgeInsets.all(10.r),
          builder: RectSwiperPaginationBuilder(
              activeSize: Size(7.r, 7.r),
              size: Size(7.r, 7.r),
              space: 4.w,
              activeColor: AppColors.redBtnColor,
              color: Colors.white));
    } else {
      //圆形白色
      return SwiperPagination(
          margin: EdgeInsets.all(12.r),
          builder: DotSwiperPaginationBuilder(
              activeSize: 6.r,
              size: 6.r,
              activeColor: Colors.white,
              color: AppColors.whiteColor80));
    }
  }
}
