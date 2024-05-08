import 'package:starfish_tenement_app/datas/news_type_data.dart';

import '../datas/home_banner_data.dart';
import '../datas/news_banner_data.dart';
import 'mock_builder.dart';

class MockApi {
  MockApi._();

  static MockApi instance = MockApi._();

  Future<dynamic> getJson(String jsonName) {
    return MockBuilder.builder.loadJson(jsonName: jsonName);
  }

  ///首页banner数据
  Future<HomeBannerData> mockHomeBanner() async {
    var json = await getJson("home_banner_data");
    return HomeBannerData.fromJson(json);
  }

  ///首页房源列表
  Future mockHomeHouseList() async {
    var json = await getJson("home_house_data");
  }

  ///咨询页banner数据
  Future<NewsBannerData> mockNewsBannerData() async {
    try {
      var json = await getJson("news_banner_data");
      print(json);
      return NewsBannerData.fromJson(json);
    } catch (e) {
      return NewsBannerData();
    }
  }

  ///资讯分类列表
  Future<NewsTypeData> mockNewsTypeData() async {
    var json = await getJson("news_type_list_data");
    return NewsTypeData.fromJson(json);
  }
}
