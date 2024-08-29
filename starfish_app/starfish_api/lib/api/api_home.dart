import 'package:dio/dio.dart';
import 'package:starfish_http/http/dio_instance.dart';

import 'models/better_choice_data.dart';
import 'models/home_banner_data.dart';

class ApiHome {
  ApiHome._();

  static ApiHome api = ApiHome._();

  ///首页本期优选
  Future<BetterChoiceListData> getBetterChoice() async {
    Response resp = await DioInstance.instance().post(path: "/betterChoice/choiceList");
    return BetterChoiceListData.fromJson(resp.data);
  }

  ///首页banner
  Future<HomeBannerListData> getHomeBanner() async {
    Response resp = await DioInstance.instance().post(path: "/banner/bannerList");
    return HomeBannerListData.fromJson(resp.data);
  }
}
