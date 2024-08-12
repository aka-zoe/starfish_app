import 'package:flutter/material.dart';
import 'package:starfish_tenement_app/api/api_mine.dart';
import 'package:starfish_tenement_app/api/models/app_info_data.dart';

class MineViewModel with ChangeNotifier {
  AppInfoData? infoData;

  ///获取当前用户相关的APP信息
  Future getAppInfo() async {
    try {
      infoData = await ApiMine.api.getAppInfo();
      notifyListeners();
    } catch (e) {
      print("MineViewModel getAppInfo $e 当前未登录");
    }
  }

  ///是否开启消息
  Future setOpenMsg(bool openFlag) async {
    infoData?.openMsg = openFlag;
    //调接口
    ApiMine.api.setOpenMsg(openFlag);
    notifyListeners();
  }
}
