import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:starfish_api/api/models/home_banner_data.dart';
import 'package:starfish_api/api/models/house_res_data.dart';
import 'package:starfish_common_ui/common_ui/app_bar/app_search_bar.dart';
import 'package:starfish_common_ui/common_ui/banner/home_banner_widget.dart';
import 'package:starfish_common_ui/common_ui/filter/filter_menu_widget.dart';
import 'package:starfish_common_ui/common_ui/house_list/house_res_list_item.dart';
import 'package:starfish_common_ui/common_ui/sliver/sliver_header.dart';
import 'package:starfish_common_ui/common_ui/title/big_title.dart';
import 'package:starfish_tenement_app/pages/house_res/detail/house_res_detail_page.dart';
import 'package:starfish_tenement_app/pages/house_res/house_resource_vm.dart';
import 'package:starfish_route/route/route_utils.dart';


///房源列表页面
class HouseResourcePage extends StatefulWidget {
  const HouseResourcePage({super.key});

  @override
  State<StatefulWidget> createState() {
    return _HouseResourcePageState();
  }
}

class _HouseResourcePageState extends State<HouseResourcePage> {
  final HouseResourceVM _resourceVm = HouseResourceVM();

  @override
  void initState() {
    super.initState();
    _resourceVm.getHomeData();
    _resourceVm.getHouseRes();
  }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider<HouseResourceVM>(
        create: (context) {
          return _resourceVm;
        },
        child: Scaffold(
            backgroundColor: Colors.white,
            body: SafeArea(
              child: Padding(
                padding: EdgeInsets.symmetric(horizontal: 14.w),
                child: CustomScrollView(
                  slivers: [
                    SliverToBoxAdapter(
                        child: Column(children: [
                      //搜索栏
                      AppSearchBar(
                        hintText: "寻找附近房源",
                        margin: EdgeInsets.zero,
                        rightIconPadding: EdgeInsets.only(left: 25.w, right: 20.w),
                        searchType: SearchType.square,
                        showLeftMenu: false,
                        //消息按钮
                        showRightIcon: true,
                        onRightIconTap: () {
                          //点击消息按钮
                        },
                      ),
                      SizedBox(height: 21.h),
                      _banner(),
                    ])),
                    SliverHeader(children: [
                      BigTitle(bigTitle: "新房源"),
                      _filterArea(),
                    ]),
                    //房源列表
                    Selector<HouseResourceVM, List<HouseResData>?>(
                        builder: (context, houseResList, child) {
                      return SliverList(
                          delegate: SliverChildBuilderDelegate((context, index) {
                        HouseResData? item = houseResList?[index];
                        return HouseListItem(
                          data: item,
                          onTap: () {
                            RouteUtils.push(context, HouseResDetailPage(id: item?.id));
                          },
                        );
                      }, childCount: houseResList?.length ?? 0));
                    }, selector: (context, vm) {
                      return vm.houseResList;
                    })
                  ],
                ),
              ),
            )));
  }

  ///banner轮播
  Widget _banner() {
    return Selector<HouseResourceVM, List<HomeBannerData>?>(
        builder: (context, List<HomeBannerData>? bList, child) {
      return BannerWidget(
          height: 152.h,
          dotType: BannerDotType.square,
          bannerData: _resourceVm.generalBannerList(bList),
          bannerClick: (index) {
            //banner点击
          });
    }, selector: (context, vm) {
      return vm.banner;
    });
  }

  ///筛选条件区域
  Widget _filterArea() {
    return Row(mainAxisAlignment: MainAxisAlignment.spaceBetween, children: [
      FilterMenuWidget(name: "区域", selected: true),
      FilterMenuWidget(name: "租金"),
      FilterMenuWidget(name: "户型"),
      FilterMenuWidget(name: "筛选")
    ]);
  }
}
