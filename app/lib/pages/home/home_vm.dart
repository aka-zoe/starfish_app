import 'package:flutter/cupertino.dart';
import 'package:starfish_tenement_app/datas/home_banner_data.dart';
import 'package:starfish_tenement_app/mock/mock_api.dart';

class HomeVM extends ChangeNotifier {
  List<HomeBanner>? banner = [];
  List<BetterChoice>? betterChoice = [];

  Future getHomeData() async {
    HomeBannerData data = await MockApi.instance.mockHomeBanner();
    if (data.data != null) {
      if (data.data?.banner?.isNotEmpty == true) {
        banner = data.data?.banner;
      }

      if (data.data?.betterChoice?.isNotEmpty == true) {
        betterChoice = data.data?.betterChoice;
      }
      notifyListeners();
    }
  }

  List<String?> generalBannerList(List<HomeBanner>? banner) {
    List<String?> b = [];
    banner?.forEach((element) {
      b.add(element.imageUrl);
    });
    return b;
  }
}
