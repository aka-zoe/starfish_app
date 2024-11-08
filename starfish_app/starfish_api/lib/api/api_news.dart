import 'package:dio/dio.dart';
import 'package:starfish_http/http/dio_instance.dart';

import 'models/app_news_data.dart';

class ApiNews {
  ApiNews._();

  static ApiNews api = ApiNews._();

  ///获取APP资讯
  ///[type] 1=最新咨询、2=热门资讯、3=雷区、4=行情、5=科普
  Future<AppNewsData> getAppNews(int type) async {
    Response resp =
        await DioInstance.instance().post(path: "/news/getNewList", queryParameters: {"type": type});
    return AppNewsData.fromJson(resp.data);
  }
}
