import 'package:flutter/cupertino.dart';
import 'package:starfish_api/api/api_home.dart';
import 'package:starfish_api/api/api_house.dart';
import 'package:starfish_api/api/models/better_choice_data.dart';
import 'package:starfish_api/api/models/home_banner_data.dart';
import 'package:starfish_api/api/models/house_res_data.dart';
import 'package:starfish_utils/utils/string_utils.dart';

class HomeVM extends ChangeNotifier {
  List<HomeBannerData>? banner = [];
  List<BetterChoiceData>? betterChoice = [];
  List<HouseResData>? houseResList = [];
  String currentCity = "";
  bool showMap = false;

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

  ///首页本期优选
  Future getBetterChoice() async {
    BetterChoiceListData data = await ApiHome.api.getBetterChoice();
    if (data.choiceList != null) {
      if (data.choiceList?.isNotEmpty == true) {
        betterChoice = data.choiceList;
      }
      notifyListeners();
    }
  }

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

  void changeLocation(String city) {
    //去重
    if (currentCity == city) {
      return;
    }
    currentCity = city;
    notifyListeners();
  }

  void setShowMap() {
    showMap = !showMap;
    notifyListeners();
  }

  List<String?> generalBannerList(List<HomeBannerData>? banner) {
    List<String?> b = [];
    banner?.forEach((element) {
      b.add(element.imgurl);
    });
    return b;
  }

  BetterChoiceData? generalBetterChoiceData(int index) {
    try {
      if (betterChoice != null && (betterChoice?.length ?? 0) >= 3) {
        return betterChoice?[index];
      }
    } catch (e) {
      return null;
    }
    return null;
  }
}
