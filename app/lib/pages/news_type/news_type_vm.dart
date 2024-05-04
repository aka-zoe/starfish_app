import 'package:flutter/cupertino.dart';
import 'package:starfish_tenement_app/datas/news_type_data.dart';
import 'package:starfish_tenement_app/mock/mock_api.dart';

class NewsTypeViewModel with ChangeNotifier {
  List<NewsTypeListData>? data;

  Future getNewsTypeList() async {
    NewsTypeData typeData = await MockApi.instance.mockNewsTypeData();
    if (typeData.data?.isNotEmpty == true) {
      data = typeData.data;
      notifyListeners();
    }
  }
}
