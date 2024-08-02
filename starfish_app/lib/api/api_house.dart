import 'package:dio/dio.dart';
import 'package:starfish_tenement_app/api/models/better_choice_data.dart';
import 'package:starfish_tenement_app/api/models/home_banner_data.dart';
import 'package:starfish_tenement_app/api/models/house_res_data.dart';
import 'package:starfish_tenement_app/api/models/house_res_detail_data.dart';
import 'package:starfish_tenement_app/http/dio_instance.dart';

class ApiHouse {
  ApiHouse._();

  static ApiHouse api = ApiHouse._();

  ///获取房源
  Future<HouseResListData> getHouseRes() async {
    Response resp = await DioInstance.instance().post(path: "/houseResource/houseResources");
    return HouseResListData.fromJson(resp.data);
  }

  ///获取房源明细
  Future<HouseResDetailData> getHouseResDetail(num? id) async {
    Response resp = await DioInstance.instance()
        .post(path: "/houseResource/houseResourceDetail", queryParameters: {"id": id});

    return HouseResDetailData.fromJson(resp.data);
  }
}
