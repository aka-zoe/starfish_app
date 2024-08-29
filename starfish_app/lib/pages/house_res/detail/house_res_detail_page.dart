import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:starfish_api/api/models/house_res_data.dart';
import 'package:starfish_api/api/models/house_res_detail_data.dart';
import 'package:starfish_common_ui/common_ui/banner/home_banner_widget.dart';
import 'package:starfish_common_ui/common_ui/buttons/red_button.dart';
import 'package:starfish_common_ui/common_ui/house_list/house_res_list_item.dart';
import 'package:starfish_common_ui/common_ui/styles/app_colors.dart';
import 'package:starfish_common_ui/common_ui/title/app_text.dart';
import 'package:starfish_common_ui/common_ui/title/big_title.dart';
import 'package:starfish_tenement_app/pages/house_res/detail/house_res_detail_vm.dart';
import 'package:starfish_tenement_app/pages/mine/booked/booked_house_page.dart';
import 'package:starfish_route/route/route_utils.dart';

///房源明细页
class HouseResDetailPage extends StatefulWidget {
  const HouseResDetailPage({super.key, this.id});

  final num? id;

  @override
  State createState() {
    return _HouseResDetailPageState();
  }
}

class _HouseResDetailPageState extends State<HouseResDetailPage> {
  HouseResDetailViewModel viewModel = HouseResDetailViewModel();

  @override
  void initState() {
    super.initState();

    //获取房源明细
    viewModel.getDetailData(widget.id);
    //附近房源
    viewModel.getHouseRes();
  }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
      create: (context) {
        return viewModel;
      },
      child: Scaffold(
          backgroundColor: Colors.white,
          body: SafeArea(
            child: Scaffold(
                backgroundColor: Colors.white,
                body: SingleChildScrollView(
                    child: Column(children: [
                  SizedBox(
                      height: 210.h,
                      child: Stack(children: [
                        //房源图片banner
                        _banner(),
                        //顶部关闭、分享、收藏按钮
                        _titleOperationBar(),
                        //banner组件的页码指示器
                        _bannerPageCount()
                      ])),
                  //顶部房源信息
                  _totalHouseInfo(),
                  BigTitle(bigTitle: "基本信息", padding: EdgeInsets.only(left: 14.w)),
                  //房源基本信息
                  _houseBasicInfo(),
                  BigTitle(bigTitle: "配套设施", padding: EdgeInsets.only(left: 14.w)),
                  //配套设施网格布局
                  Consumer<HouseResDetailViewModel>(builder: (context, vm, child) {
                    return _facilityGridWidget(vm.detailData);
                  }),
                  BigTitle(bigTitle: "附近位置", padding: EdgeInsets.only(left: 14.w)),
                  //地图缩略图
                  _mapView(),
                  BigTitle(bigTitle: "附近房源", padding: EdgeInsets.only(left: 14.w)),
                  //附近房源列表
                  _nearbyHouseResList()
                ])),

                //底部按钮操作栏
                bottomNavigationBar: Container(
                    decoration: BoxDecoration(
                        border: Border(top: BorderSide(width: 1.h, color: Color(0xFFf5f4f4)))),
                    height: 51.h,
                    //房源联系人以及电话资讯和立即预约
                    child: _callOrSubscribe())),
          )),
    );
  }

  ///顶部关闭、分享、收藏按钮
  Widget _titleOperationBar() {
    return Padding(
        padding: EdgeInsets.only(top: 18.h, left: 21.w, right: 21.w),
        child: Row(
          children: [
            //关闭页面
            GestureDetector(
                onTap: () {
                  Navigator.pop(context);
                },
                child: Image.asset("assets/images/icon_house_detail_close.png",
                    width: 32.r, height: 32.r)),
            Expanded(child: SizedBox()),
            //收藏按钮
            Selector<HouseResDetailViewModel, bool>(builder: (context, collected, child) {
              return GestureDetector(
                  onTap: () {
                    //设置收藏
                    viewModel.setCollect(!collected);
                  },
                  child: Image.asset(
                    "assets/images/icon_house_detail_collect.png",
                    width: 32.r,
                    height: 32.r,
                    //收藏状态显示黄色
                    color: collected == true ? AppColors.collectColor : null,
                  ));
            }, selector: (context, vm) {
              return vm.collected;
            }),
            10.horizontalSpace,
            GestureDetector(
                onTap: () {},
                child: Image.asset("assets/images/icon_house_detail_share.png",
                    width: 32.r, height: 32.r)),
          ],
        ));
  }

  ///房源图片banner
  Widget _banner() {
    return Consumer<HouseResDetailViewModel>(builder: (context, vm, child) {
      return BannerWidget(
        bannerData: vm.detailData?.imageList,
        dotType: BannerDotType.none,
        height: 210.h,
        onIndexChanged: (index) {
          vm.bannerIndexChange(index);
        },
      );
    });
  }

  ///banner组件的页码指示器
  Widget _bannerPageCount() {
    return Align(
        alignment: Alignment.bottomRight,
        child: Consumer<HouseResDetailViewModel>(
          builder: (context, vm, child) {
            //没有banner数据返回时不展示页码
            if (vm.detailData?.imageList?.isEmpty == true) {
              return const SizedBox();
            }
            return Container(
                margin: EdgeInsets.only(bottom: 26.h, right: 23.w),
                width: 44.w,
                height: 23.h,
                decoration: BoxDecoration(
                    borderRadius: BorderRadius.all(Radius.circular(11.r)),
                    color: const Color(0x4d000000)),
                child: Row(mainAxisAlignment: MainAxisAlignment.center, children: [
                  // Selector<HouseResDetailViewModel, int>(builder: (context, child, index) {
                  //   return AppText(text: "$index", textColor: Colors.white, fontSize: 15.sp);
                  // }, selector: (context, vm) {
                  //   return vm.currBannerIndex;
                  // }),
                  AppText(text: "${vm.currBannerIndex}", textColor: Colors.white, fontSize: 15.sp),
                  AppText(text: "/", textColor: Colors.white, fontSize: 15.sp),
                  AppText(
                      text: "${vm.detailData?.imageList?.length ?? 0}",
                      textColor: Colors.white,
                      fontSize: 15.sp)
                ]));
          },
        ));
  }

  ///顶部房源信息
  Widget _totalHouseInfo() {
    return Container(
        padding: EdgeInsets.only(top: 19.h, bottom: 19.h, left: 16.w, right: 20.w),
        margin: EdgeInsets.all(20.r),
        decoration: BoxDecoration(
            color: Colors.white,
            borderRadius: BorderRadius.all(Radius.circular(10.r)),
            boxShadow: [
              BoxShadow(
                  color: Color(0x80d9d9d9), offset: Offset(0, 0.9), blurRadius: 5, spreadRadius: 2)
            ]),
        child: Consumer<HouseResDetailViewModel>(
          builder: (context, vm, child) {
            return Column(crossAxisAlignment: CrossAxisAlignment.start, children: [
              AppText(
                  text: vm.generateCardTitle(), textColor: AppColors.textColor2b, fontSize: 19.sp),
              AppText(
                  text: vm.generateCardDesc(), textColor: AppColors.textColorB6, fontSize: 13.sp),
              8.verticalSpace,
              Row(
                children: [
                  AppText(
                      text: "${vm.detailData?.rent}",
                      textColor: AppColors.textRedColor39,
                      fontSize: 19.sp),
                  AppText(text: "元/月", textColor: AppColors.textRedColor6d, fontSize: 11.sp),
                  const Expanded(child: SizedBox()),
                  AppText(
                      text: "服务费：${vm.detailData?.serviceCharge}元",
                      textColor: AppColors.textColorB6,
                      fontSize: 13.sp),
                ],
              )
            ]);
          },
        ));
  }

  ///房源基本信息
  ///[checkAreaOnTap] 查看小区
  Widget _houseBasicInfo({GestureTapCallback? checkAreaOnTap}) {
    return Consumer<HouseResDetailViewModel>(builder: (context, vm, child) {
      return Container(
          padding: EdgeInsets.only(top: 20.h, left: 14.w, right: 16.w, bottom: 25.h),
          child: Column(children: [
            _basicInfoRow(_basicInfo("入住", vm.getDate(vm.detailData?.checkInDate)),
                _basicInfo("面积", "${vm.detailData?.acreage}m²")),
            10.verticalSpace,
            _basicInfoRow(_basicInfo("户型", vm.detailData?.houseTypeName),
                _basicInfo("发布", vm.getDate(vm.detailData?.publishDate))),
            10.verticalSpace,
            _basicInfoRow(
                _basicInfo("楼层", "${vm.detailData?.currentFloor}/${vm.detailData?.totalFloor}楼"),
                _basicInfo("装修", vm.detailData?.fitment)),
            10.verticalSpace,
            _basicInfoRow(_basicInfo("车位", vm.detailData?.carport == true ? "有车位" : "无"),
                _basicInfo("付款", vm.getPaymentType(vm.detailData?.paymentType))),
            10.verticalSpace,
            _basicInfoRow(
                _basicInfo("小区", vm.detailData?.houseArea),
                GestureDetector(
                    onTap: checkAreaOnTap,
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.end,
                      children: [
                        AppText(
                            text: "查看小区",
                            fontSize: 14.sp,
                            textColor: AppColors.textRedColor30,
                            fontWeight: FontWeight.w600),
                        14.horizontalSpace,
                        Image.asset(
                          "assets/images/icon_right_arrow_grey.png",
                          width: 7.w,
                          height: 12.h,
                          color: Color(0xff8a8a8a),
                        ),
                      ],
                    ))),
          ]));
    });
  }

  ///房源基本信息左右结构组件
  Widget _basicInfoRow(Widget info1, Widget info2) {
    return Row(children: [Expanded(flex: 1, child: info1), Expanded(flex: 1, child: info2)]);
  }

  ///房源基本信息基本组件
  Widget _basicInfo(String? title, String? content) {
    return Row(children: [
      AppText(text: title ?? "", fontSize: 14.sp, textColor: AppColors.textColorAd),
      17.horizontalSpace,
      AppText(text: content ?? "", fontSize: 14.sp, textColor: AppColors.textColor4a)
    ]);
  }

  ///配套设施网格布局
  Widget _facilityGridWidget(HouseResDetailData? detailData) {
    //`bed`              int comment '床：1=true,0=false',
    //     `washing_machine`  int comment '洗衣机：1=true,0=false',
    //     `refrigerator`     int comment '冰箱：1=true,0=false',
    //     `air_conditioner`  int comment '空调：1=true,0=false',
    //     `wifi`             int comment 'wifi：1=true,0=false',
    //     `sofa`             int comment '沙发：1=true,0=false',
    //     `table_chair`      int comment '桌椅：1=true,0=false',
    //     `tv`               int comment '电视：1=true,0=false',
    //     `water_heater`     int comment '热水器：1=true,0=false',
    //     `cook`             int comment '可做饭：1=true,0=false',
    //     `heating`          int comment '暖气：1=true,0=false',
    //     `balcony`          int comment '阳台：1=true,0=false',
    var data = [
      ["床", "assets/images/icon_house_detail_chuang.png", "${detailData?.bed ?? false}"],
      [
        "洗衣机",
        "assets/images/icon_house_detail_xiyiji.png",
        "${detailData?.washingMachine ?? false}"
      ],
      [
        "冰箱",
        "assets/images/icon_house_detail_bingxiang.png",
        "${detailData?.refrigerator ?? false}"
      ],
      [
        "空调",
        "assets/images/icon_house_detail_kongtiao.png",
        "${detailData?.airConditioner ?? false}"
      ],
      ["WIFI", "assets/images/icon_house_detail_wifi.png", "${detailData?.wifi ?? false}"],
      ["沙发", "assets/images/icon_house_detail_shafa.png", "${detailData?.sofa ?? false}"],
      ["桌椅", "assets/images/icon_house_detail_zhuoyi.png", "${detailData?.tableChair ?? false}"],
      ["电视", "assets/images/icon_house_detail_tv.png", "${detailData?.tv ?? false}"],
      [
        "热水器",
        "assets/images/icon_house_detail_reshuiqi.png",
        "${detailData?.waterHeater ?? false}"
      ],
      ["可做饭", "assets/images/icon_house_detail_cook.png", "${detailData?.cook ?? false}"],
      ["暖气", "assets/images/icon_house_detail_nuanqi.png", "${detailData?.heating ?? false}"],
      ["阳台", "assets/images/icon_house_detail_yangtai.png", "${detailData?.balcony ?? false}"],
    ];
    return Container(
        padding: EdgeInsets.only(top: 15.h, bottom: 15.h),
        child: GridView.builder(
            physics: const NeverScrollableScrollPhysics(),
            shrinkWrap: true,
            itemCount: data.length,
            gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 5),
            itemBuilder: (context, index) {
              return _facilityWidget(
                title: data[index][0],
                imgPath: data[index][1],
                exist: data[index][2] == 'true',
              );
            }));
  }

  ///配套设施组件
  Widget _facilityWidget({required String title, required String imgPath, required bool exist}) {
    return SizedBox(
        width: 35.w,
        child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              SizedBox(width: 32.w, height: 32.h, child: Image.asset(imgPath)),
              7.verticalSpace,
              AppText(text: title, fontSize: 13.sp, textColor: AppColors.textColor59)
            ]));
  }

  ///地图缩略图
  Widget _mapView() {
    return Container(
        color: Colors.grey,
        margin: EdgeInsets.only(left: 14.w, right: 14.w, top: 25.h, bottom: 25.h),
        height: 162.h,
        width: double.infinity,
        alignment: Alignment.center,
        child: Image.asset("assets/images/image_map.png",
            width: double.infinity, height: double.infinity, fit: BoxFit.fill));
  }

  ///附近房源列表
  Widget _nearbyHouseResList() {
    return Container(
        padding: EdgeInsets.only(left: 15.w, right: 15.w),
        child: Consumer<HouseResDetailViewModel>(builder: (context, vm, child) {
          return ListView.builder(
              itemCount: vm.houseResList?.length ?? 0,
              shrinkWrap: true,
              physics: NeverScrollableScrollPhysics(),
              itemBuilder: (context, index) {
                HouseResData? item = vm.houseResList?[index];
                return HouseListItem(
                  data: item,
                  onTap: () {},
                );
              });
        }));
  }

  ///房源联系人以及电话资讯和立即预约
  Widget _callOrSubscribe() {
    return Row(
      mainAxisAlignment: MainAxisAlignment.start,
      children: [
        Expanded(flex: 1, child: _agentInfo(agentName: "王大锤", type: "中介")),
        Expanded(
            flex: 1,
            child: AppButton(
              type: AppButtonType.black,
              buttonText: "电话咨询",
              margin: EdgeInsets.zero,
            )),
        Expanded(
            flex: 1,
            child: AppButton(
              type: AppButtonType.red,
              buttonText: "立即预约",
              margin: EdgeInsets.zero,
              onTap: () {
                RouteUtils.push(context, SubscribeHousePage(detailData: viewModel.detailData));
              },
            ))
      ],
    );
  }

  ///中介，房源联系人信息
  Widget _agentInfo({required String agentName, required String type}) {
    return Container(
        padding: EdgeInsets.only(left: 15.w, right: 10.w),
        child: Row(children: [
          Image.network(
              "https://q6.itc.cn/q_70/images03/20240601/80b789341c9b45cb8a76238650d288a5.png",
              width: 30.w,
              height: 30.h,
              fit: BoxFit.fill),
          9.horizontalSpace,
          Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                AppText(text: agentName, fontSize: 14.sp, textColor: AppColors.textColor4D),
                2.verticalSpace,
                AppText(text: type, fontSize: 12.sp, textColor: AppColors.textColorB8)
              ])
        ]));
  }
}
