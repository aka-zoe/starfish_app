import 'package:dio/dio.dart';
import 'package:starfish_web/http/dio_instance.dart';
import 'package:starfish_web/repository/data/better_choice_data.dart';
import 'package:starfish_web/repository/data/user_info_data.dart';
import 'data/banner_list_data.dart';

class Api {
  static Api api = Api._();

  Api._();

  ///登录
  Future<UserInfoData> login(String name, String pwd) async {
    Response res = await DioInstance.instance()
        .post(path: "/auth/user/login", data: {"name": name, "password": pwd});
    var userInfoData = UserInfoData.fromJson(res.data);
    return userInfoData;
  }

  ///banner列表
  Future<List<BannerListItemData>?> bannerList() async {
    Response response = await DioInstance.instance().get(path: "/banner/bannerList");
    var listData = BannerListData.fromJson(response.data);
    return listData.bannerList;
  }

  //添加Banner
  Future<bool?> addBanner(BannerListItemData? itemData) async {
    Response response = await DioInstance.instance().post(path: "/banner/insertBanner", data: {
      "imgurl": itemData?.imgurl,
      "link": itemData?.link,
      "activename": itemData?.activename,
      "type": itemData?.type,
      "status": itemData?.status,
    });
    return boolCallback(response.data);
  }

  //更新Banner
  Future<bool?> updateBanner(BannerListItemData? itemData) async {
    Response response =
        await DioInstance.instance().post(path: "/banner/updateBanner", data: itemData?.toJson());
    return boolCallback(response.data);
  }

  //删除Banner
  Future<bool?> deleteBanner(String? id) async {
    Response response = await DioInstance.instance()
        .delete(path: "/banner/deleteBanner", queryParameters: {"id": id});
    return boolCallback(response.data);
  }

  //本期优选列表
  Future<List<BetterChoiceData>?> betterChoiceList() async {
    Response response = await DioInstance.instance().get(path: "/betterChoice/choiceList");
    var listData = BetterChoiceListData.fromJson(response.data);
    return listData.choiceList;
  }

  //添加本期优选
  Future<bool?> addBetterChoice(BetterChoiceData? itemData) async {
    Response response =
        await DioInstance.instance().post(path: "/betterChoice/insertChoice", data: {
      "title": itemData?.title,
      "subtitle": itemData?.subtitle,
      "resid": 1,
      "imgurl": itemData?.imgurl,
      "link": itemData?.link,
      "type": 0,
      "status": 0,
    });
    return boolCallback(response.data);
  }

  //更新本期优选
  Future<bool?> updateBetterChoice(BetterChoiceData? itemData) async {
    Response response = await DioInstance.instance()
        .post(path: "/betterChoice/updateChoice", data: itemData?.toJson());
    return boolCallback(response.data);
  }

  //删除本期优选
  Future<bool?> deleteBetterChoice(String? id) async {
    Response response = await DioInstance.instance()
        .delete(path: "/betterChoice/deleteChoice", queryParameters: {"id": id});
    return boolCallback(response.data);
  }

  bool? boolCallback(dynamic data) {
    if (data != null && data is bool) {
      return data;
    } else {
      return false;
    }
  }
}
