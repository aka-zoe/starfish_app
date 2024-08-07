import 'package:flutter/cupertino.dart';
import 'package:starfish_tenement_app/api/api_news.dart';
import 'package:starfish_tenement_app/api/models/app_news_data.dart';
import 'package:starfish_tenement_app/mock/datas/news_banner_data.dart';
import 'package:starfish_tenement_app/mock/mock_api.dart';

///咨询列表页业务逻辑层
class NewsListViewModel with ChangeNotifier {
  // List<NewsBanner>? banner;

  List<AppNewsItemData>? bannerNews;
  List<AppNewsItemData>? hotNews;

  // Future getBanner() async {
  //   NewsBannerData bannerData = await MockApi.instance.mockNewsBannerData();
  //   if (bannerData.data?.banner != null) {
  //     banner = bannerData.data?.banner;
  //   }
  //   notifyListeners();
  // }

  ///最新咨询
  Future getBannerNews() async {
    var news = await getNewsData(1);
    bannerNews = news ?? [];
    notifyListeners();
  }

  ///热门资讯
  Future getHotNews() async {
    var news = await getNewsData(2);
    hotNews = news ?? [];
    notifyListeners();
  }

  ///获取APP资讯
  ///[type] 1=最新咨询、2=热门资讯、3=雷区、4=行情、5=科普
  Future<List<AppNewsItemData>?> getNewsData(int type) async {
    AppNewsData data = await ApiNews.api.getAppNews(type);
    return data.newList;
  }
}
