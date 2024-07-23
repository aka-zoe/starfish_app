import 'package:flutter/cupertino.dart';
import 'package:starfish_tenement_app/api/home_api.dart';
import 'package:starfish_tenement_app/api/models/better_choice_data.dart';
import 'package:starfish_tenement_app/api/models/home_banner_data.dart';
import 'package:starfish_tenement_app/api/models/house_res_data.dart';

class HomeVM extends ChangeNotifier {
  List<HomeBannerData>? banner = [];
  List<BetterChoiceData>? betterChoice = [];
  List<HouseResData>? houseResList = [];

  ///首页banner
  Future getHomeData() async {
    HomeBannerListData data = await HomeApi.api.getHomeBanner();
    if (data.bannerList != null) {
      if (data.bannerList?.isNotEmpty == true) {
        banner = data.bannerList;
      }
      notifyListeners();
    }
  }

  ///首页本期优选
  Future getBetterChoice() async {
    BetterChoiceListData data = await HomeApi.api.getBetterChoice();
    if (data.choiceList != null) {
      if (data.choiceList?.isNotEmpty == true) {
        betterChoice = data.choiceList;
      }
      notifyListeners();
    }
  }

  ///获取房源
  Future getHouseRes() async {
    HouseResListData data = await HomeApi.api.getHouseRes();
    if (data.houseResList != null) {
      if (data.houseResList?.isNotEmpty == true) {
        houseResList = data.houseResList;
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
