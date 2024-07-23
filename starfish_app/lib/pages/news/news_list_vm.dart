import 'package:flutter/cupertino.dart';
import 'package:starfish_tenement_app/mock/datas/news_banner_data.dart';
import 'package:starfish_tenement_app/mock/mock_api.dart';

///咨询列表页业务逻辑层
class NewsListViewModel with ChangeNotifier {
  List<NewsBanner>? banner;

  Future getBanner() async {
    NewsBannerData bannerData = await MockApi.instance.mockNewsBannerData();
    if (bannerData.data?.banner != null) {
      banner = bannerData.data?.banner;
    }
    notifyListeners();
  }
}
