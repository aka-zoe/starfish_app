import 'package:dio/dio.dart';
import 'package:starfish_tenement_app/api/models/app_info_data.dart';
import 'package:starfish_tenement_app/api/models/app_news_data.dart';
import 'package:starfish_tenement_app/api/models/better_choice_data.dart';
import 'package:starfish_tenement_app/api/models/home_banner_data.dart';
import 'package:starfish_tenement_app/api/models/house_res_data.dart';
import 'package:starfish_tenement_app/api/models/house_res_detail_data.dart';
import 'package:starfish_tenement_app/api/models/my_booked_list_data.dart';
import 'package:starfish_tenement_app/http/dio_instance.dart';

class ApiMine {
  ApiMine._();

  static ApiMine api = ApiMine._();

  ///获取当前用户相关的APP信息
  Future<AppInfoData> getAppInfo() async {
    Response resp = await DioInstance.instance().post(path: "/appConfig/getAppInfo");
    return AppInfoData.fromJson(resp.data);
  }

  ///是否开启消息
  Future<bool> setOpenMsg(bool? openFlag) async {
    Response response = await DioInstance.instance()
        .post(path: "auth/user/openMsg", queryParameters: {"openFlag": openFlag});
    if (response.data is bool) {
      return response.data;
    }
    return false;
  }

  ///根据类型获取收藏列表
  Future<MyBookedListData> getCollectList({int? type = 1}) async {
    Response response = await DioInstance.instance()
        .post(path: "/collect/collectList", queryParameters: {"type": type});
    return MyBookedListData.fromJson(response.data);
  }

  ///添加收藏
  Future<bool> addCollect({
    int? collecttype,
    num? houseresid,
    num? newsid,
    String? title,
  }) async {
    Response response = await DioInstance.instance().post(path: "/collect/insertCollect", data: {
      "collecttype": collecttype, //收藏分类：1=房源，2=资讯
      "houseresid": houseresid, //房源id
      "newsid": newsid, //资讯id
      "title": title
    });
    if (response.data is bool) {
      return response.data;
    }
    return false;
  }

  ///取消收藏
  Future<bool> cancelCollect({int? type, num? houseResId, num? newsId, num? id}) async {
    Response response =
        await DioInstance.instance().post(path: "/collect/cancelCollect", queryParameters: {
      "type": type,
      "houseResId": houseResId,
      "newsId": newsId,
      "id": id,
    });
    if (response.data is bool) {
      return response.data;
    }
    return false;
  }
}
