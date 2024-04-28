import '../datas/home_banner_data.dart';
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
}
