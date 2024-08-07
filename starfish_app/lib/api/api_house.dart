import 'package:dio/dio.dart';
import 'package:starfish_tenement_app/api/models/better_choice_data.dart';
import 'package:starfish_tenement_app/api/models/home_banner_data.dart';
import 'package:starfish_tenement_app/api/models/house_res_booked_data.dart';
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

  ///获取房源预约记录
  Future<HouseResBookedData> bookedHouseList() async {
    Response resp = await DioInstance.instance().post(path: "/bookedHouse/bookedHouseList");

    return HouseResBookedData.fromJson(resp.data);
  }

  ///提交房源预约信息
  Future<bool> submitBookedHouse(
      {num? houseresid,
      num? bookedtime,
      num? bookeduserid,
      String? userphone,
      String? username}) async {
    Response resp = await DioInstance.instance().post(path: "/bookedHouse/saveBookedHouse", data: {
      "houseresid": houseresid, //房源id
      "bookedtime": bookedtime, //预约时间戳
      "bookeduserid": bookeduserid, //被预约人/中介
      "userphone": userphone, //预约人电话
      "username": username //预约人姓名
    });
    if (resp.data != null && resp.data is bool) {
      return resp.data;
    }
    return false;
  }
}
