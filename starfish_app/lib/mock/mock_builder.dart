import 'dart:convert';

import 'package:flutter/services.dart';

///mock数据构造器，加载assets文件夹中json文件
class MockBuilder {
  MockBuilder._();

  static MockBuilder builder = MockBuilder._();

  final String _assetsPath = "assets/json/";

  ///[jsonName] assets文件夹中的json文件名称  文件名称即可，例如：home.json -> home
  Future<dynamic> loadJson({required String jsonName}) async {
    try {
      var jsonStr = await rootBundle.loadString("$_assetsPath$jsonName.json");
      dynamic json = jsonDecode(jsonStr);
      if (json == null) {
        return "";
      }
      return json;
    } catch (e) {
      print("loadJson e=$e");
      return "MockBuilder: Json mock error!";
    }
  }
}
