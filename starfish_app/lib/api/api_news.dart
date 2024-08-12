import 'package:dio/dio.dart';
import 'package:starfish_tenement_app/api/models/app_news_data.dart';
import 'package:starfish_tenement_app/api/models/better_choice_data.dart';
import 'package:starfish_tenement_app/api/models/home_banner_data.dart';
import 'package:starfish_tenement_app/api/models/house_res_data.dart';
import 'package:starfish_tenement_app/api/models/house_res_detail_data.dart';
import 'package:starfish_tenement_app/http/dio_instance.dart';

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
