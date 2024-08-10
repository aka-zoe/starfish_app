import 'package:dio/dio.dart';
import 'package:starfish_tenement_app/http/dio_instance.dart';

import 'models/user_info.dart';

class ApiAuth {
  ApiAuth._();

  static ApiAuth api = ApiAuth._();

  ///登录
  Future<UserInfo?> login({required String name, required String password}) async {
    Response response = await DioInstance.instance()
        .post(path: "auth/user/login", data: {"name": name, "password": password});
    return UserInfo.fromJson(response.data);
  }

  //注册
  Future<bool> register(
      {required String name, required String password, required String rePassword}) async {
    Response response = await DioInstance.instance().post(
        path: "auth/user/register",
        data: {"name": name, "password": password, "rePassword": rePassword});
    if (response.data is bool) {
      return response.data;
    }
    return false;
  }


}
