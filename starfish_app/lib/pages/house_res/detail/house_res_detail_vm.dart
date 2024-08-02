import 'package:flutter/cupertino.dart';
import 'package:starfish_tenement_app/api/api_house.dart';
import 'package:starfish_tenement_app/api/models/house_res_detail_data.dart';

class HouseResDetailViewModel with ChangeNotifier {
  HouseResDetailData? detailData;

  ///获取房源明细
  Future getDetailData(num? id) async {
    detailData = await ApiHouse.api.getHouseResDetail(id);
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
}
