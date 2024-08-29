import 'package:flutter/cupertino.dart';
import 'package:starfish_api/api/api_home.dart';
import 'package:starfish_api/api/api_house.dart';
import 'package:starfish_api/api/models/home_banner_data.dart';
import 'package:starfish_api/api/models/house_res_data.dart';


class HouseResourceVM with ChangeNotifier {
  List<HomeBannerData>? banner = [];
  List<HouseResData>? houseResList = [];

  ///获取房源
  Future getHouseRes() async {
    HouseResListData data = await ApiHouse.api.getHouseRes();
    if (data.houseResList != null) {
      if (data.houseResList?.isNotEmpty == true) {
        houseResList = data.houseResList;
      }
      notifyListeners();
    }
  }

  ///首页banner
  Future getHomeData() async {
    HomeBannerListData data = await ApiHome.api.getHomeBanner();
    if (data.bannerList != null) {
      if (data.bannerList?.isNotEmpty == true) {
        banner = data.bannerList;
      }
      notifyListeners();
    }
  }

  List<String?> generalBannerList(List<HomeBannerData>? banner) {
    List<String?> b = [];
    banner?.forEach((element) {
      b.add(element.imgurl);
    });
    return b;
  }
}
