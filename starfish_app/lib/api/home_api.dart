import 'package:dio/dio.dart';
import 'package:starfish_tenement_app/api/models/better_choice_data.dart';
import 'package:starfish_tenement_app/api/models/home_banner_data.dart';
import 'package:starfish_tenement_app/api/models/house_res_data.dart';
import 'package:starfish_tenement_app/http/dio_instance.dart';

class HomeApi {
  HomeApi._();

  static HomeApi api = HomeApi._();

  ///获取房源
  Future<HouseResListData> getHouseRes() async {
    Response resp = await DioInstance.instance().post(path: "/houseResource/houseResources");
    return HouseResListData.fromJson(resp.data);
  }

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
