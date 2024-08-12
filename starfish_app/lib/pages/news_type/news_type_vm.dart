import 'package:flutter/cupertino.dart';
import 'package:starfish_tenement_app/api/api_news.dart';
import 'package:starfish_tenement_app/api/models/app_news_data.dart';

import '../../api/api_mine.dart';

class NewsTypeViewModel with ChangeNotifier {
  //雷区
  List<AppNewsItemData>? mineFieldList;

  //行情
  List<AppNewsItemData>? marketList;

  //科普
  List<AppNewsItemData>? scienceList;

  /// 1=最新咨询、2=热门资讯、3=雷区、4=行情、5=科普
  Future getNewsTypeList() async {
    mineFieldList = await getNewsData(3) ?? [];
    notifyListeners();
    marketList = await getNewsData(4) ?? [];
    notifyListeners();
    scienceList = await getNewsData(5) ?? [];
    notifyListeners();
  }

  ///获取APP资讯
  ///[type] 1=最新咨询、2=热门资讯、3=雷区、4=行情、5=科普
  Future<List<AppNewsItemData>?> getNewsData(int type) async {
    AppNewsData data = await ApiNews.api.getAppNews(type);
    return data.newList;
  }

  ///设置收藏
  ///收藏分类：1=房源，2=资讯
  Future setCollect({
    required int tabIndex,
    required int index,
    required bool collected,
    String? name,
    num? newsId,
  }) async {
    if (tabIndex == 0) {
      mineFieldList?[index].collected = !collected;
    } else if (tabIndex == 1) {
      marketList?[index].collected = !collected;
    } else {
      scienceList?[index].collected = !collected;
    }

    if (collected) {
      //取消收藏
      ApiMine.api.cancelCollect(type: 2, newsId: newsId);
    } else {
      //添加收藏
      ApiMine.api.addCollect(collecttype: 2, newsid: newsId, title: name);
    }

    notifyListeners();
  }
}
