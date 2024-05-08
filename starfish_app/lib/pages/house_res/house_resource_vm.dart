import 'package:flutter/cupertino.dart';

import '../../datas/home_banner_data.dart';
import '../../mock/mock_api.dart';

class HouseResourceVM with ChangeNotifier {
  List<HomeBanner>? banner = [];

  Future getHomeData() async {
    HomeBannerData data = await MockApi.instance.mockHomeBanner();
    if (data.data != null) {
      if (data.data?.banner?.isNotEmpty == true) {
        banner = data.data?.banner;
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
