import 'package:dio/dio.dart';
import 'package:starfish_web/http/dio_instance.dart';

import 'data/banner_list_data.dart';

class Api {
  static Api api = Api._();

  Api._();

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

  bool? boolCallback(dynamic data) {
    if (data != null && data is bool) {
      return data;
    } else {
      return false;
    }
  }
}
