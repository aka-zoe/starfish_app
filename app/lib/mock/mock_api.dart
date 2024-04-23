import 'mock_builder.dart';

class MockApi {
  Future<dynamic> getJson(String jsonName) {
    return MockBuilder.builder.loadJson(jsonName: jsonName);
  }

  ///首页banner数据
  Future mockHomeBanner() async {
    var json = await getJson("home_banner_data");
  }

  ///首页房源列表
  Future mockHomeHouseList() async {
    var json = await getJson("home_house_data");
  }
}
