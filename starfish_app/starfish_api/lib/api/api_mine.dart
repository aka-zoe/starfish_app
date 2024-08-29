import 'package:dio/dio.dart';
import 'package:starfish_http/http/dio_instance.dart';

import 'models/app_info_data.dart';
import 'models/app_news_data.dart';
import 'models/house_res_data.dart';

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
  Future getCollectList({required int type}) async {
    Response response = await DioInstance.instance()
        .post(path: "/collect/collectList", queryParameters: {"type": type});
    //房源
    if (type == 1) {
      return HouseResListData.fromJson(response.data);

      //资讯
    } else if (type == 2) {
      return AppNewsData.fromJson(response.data);
    }
    return null;
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
