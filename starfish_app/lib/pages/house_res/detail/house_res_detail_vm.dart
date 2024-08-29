import 'package:flustars/flustars.dart';
import 'package:flutter/cupertino.dart';
import 'package:starfish_api/api/api_house.dart';
import 'package:starfish_api/api/api_mine.dart';
import 'package:starfish_api/api/models/house_res_data.dart';
import 'package:starfish_api/api/models/house_res_detail_data.dart';

class HouseResDetailViewModel with ChangeNotifier {
  HouseResDetailData? detailData;

  //附近房源
  List<HouseResData>? houseResList;

  //当前banner下标
  int currBannerIndex = 1;

  bool collected = false;

  ///获取房源明细
  Future getDetailData(num? id) async {
    detailData = await ApiHouse.api.getHouseResDetail(id);
    collected = detailData?.collected ?? false;
    notifyListeners();
  }

  ///获取附近房源
  Future getHouseRes() async {
    var houseRes = await ApiHouse.api.getHouseRes();
    houseResList = houseRes.houseResList ?? [];
    notifyListeners();
  }

  ///设置收藏
  Future setCollect(bool value) async {
    detailData?.collected = value;
    collected = detailData?.collected ?? false;
    if (value) {
      //添加收藏
      ApiMine.api.addCollect(collecttype: 1, houseresid: detailData?.id, title: detailData?.name);
    } else {
      //取消收藏
      ApiMine.api.cancelCollect(type: 1, houseResId: detailData?.id);
    }

    notifyListeners();
  }

  void bannerIndexChange(int index) {
    currBannerIndex = index + 1;
    notifyListeners();
  }

  String generateCardTitle() {
    return "${detailData?.houseArea}${detailData?.houseTypeName}";
  }

  String generateCardDesc() {
    return "${detailData?.acreage}m²${detailData?.fitment}${detailData?.houseDesc}";
  }

  ///'0=押一付三，1=月付，2=押一付一，3=押一付二，4=整年租'
  String getPaymentType(num? type) {
    switch (type) {
      case 0:
        return "押一付三";
      case 1:
        return "月付";
      case 2:
        return "押一付一";
      case 3:
        return "押一付二";
      case 4:
        return "整年租";
      default:
        return "";
    }
  }

  String getDate(String? date) {
    return DateUtil.formatDate(DateTime.tryParse(date ?? ""), format: "yyyy-MM-dd");
  }
}
