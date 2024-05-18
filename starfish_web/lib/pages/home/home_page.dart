import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:starfish_web/common_ui/title/app_title.dart';
import 'package:starfish_web/pages/add_banner/add_banner_page.dart';
import 'package:starfish_web/pages/home/home_vm.dart';
import 'package:starfish_web/styles/app_colors.dart';

import '../../common_ui/expand_widget.dart';
import '../better_choice/better_choice_page.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<StatefulWidget> createState() {
    return _HomePageState();
  }
}

class _HomePageState extends State<HomePage> {
  HomeViewModel viewModel = HomeViewModel();

  @override
  void initState() {
    super.initState();
    viewModel.initMenuData();
  }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
        create: (context) {
          return viewModel;
        },
        child: Scaffold(
            backgroundColor: AppColors.verticalLimitColor,
            appBar: null,
            body: SafeArea(
                child: Row(
              children: [_menuTab(), _indexedContent()],
            ))));
  }

  Widget _menuTab() {
    return Expanded(
        flex: 2,
        child: Container(
          color: AppColors.menuBg,
          child: Column(
            children: [
              40.verticalSpace,
              ClipRRect(
                  child: Image.asset(
                    "assets/images/head.png",
                    height: 80.r,
                    width: 80.r,
                  ),
                  borderRadius: BorderRadius.circular(40.r)),
              5.verticalSpace,
              AppText(text: "海星租房管理后台", fontSize: 9.sp, textColor: AppColors.white),
              40.verticalSpace,
              Consumer<HomeViewModel>(builder: (context, vm, child) {
                return _menuList(vm.menuList);
              })
            ],
          ),
        ));
  }

  Widget _indexedContent() {
    return Expanded(
        flex: 9,
        child: Consumer<HomeViewModel>(builder: (context, vm, child) {
          return IndexedStack(
            index: vm.currentIndex,
            children: [
              AddBannerPage(),
              BetterChoicePage(),
              Container(alignment: Alignment.center, child: AppText(text: "添加房源")),
              Container(alignment: Alignment.center, child: AppText(text: "添加小区")),
              Container(alignment: Alignment.center, child: AppText(text: "添加房源图片")),
              Container(alignment: Alignment.center, child: AppText(text: "添加房源标签")),
              Container(alignment: Alignment.center, child: AppText(text: "添加户型")),
            ],
          );
        }));
  }

  Widget _menuList(List<MenuItem> menuList) {
    return ListView.builder(
        shrinkWrap: true,
        itemCount: menuList.length,
        itemBuilder: (context, index) {
          return _menuItem(
              title: menuList[index].title,
              onTap: () {
                viewModel.setSelectMenu(index);
              },
              select: menuList[index].select);
        });
  }

  Widget _menuItem({String? title, GestureTapCallback? onTap, bool? select}) {
    return GestureDetector(
        onTap: onTap,
        child: Container(
          width: double.infinity,
          color: select == true ? AppColors.menuItemSelectBg : AppColors.transparent,
          padding: EdgeInsets.only(top: 20.h, bottom: 20.h),
          child: Row(
            children: [
              10.horizontalSpace,
              Image.asset("assets/images/menu.png", width: 40.r, height: 40.r),
              5.horizontalSpace,
              AppText(
                text: title ?? "",
                textColor: AppColors.white,
                fontSize: 10.sp,
              )
            ],
          ),
        ));
  }
}
