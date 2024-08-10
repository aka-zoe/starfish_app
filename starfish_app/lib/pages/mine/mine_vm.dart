import 'package:flutter/material.dart';
import 'package:starfish_tenement_app/api/api_mine.dart';
import 'package:starfish_tenement_app/api/models/app_info_data.dart';

class MineViewModel with ChangeNotifier {
  AppInfoData? infoData;

  ///获取当前用户相关的APP信息
  Future getAppInfo() async {
    infoData = await ApiMine.api.getAppInfo();
    notifyListeners();
  }

  ///是否开启消息
  Future setOpenMsg(bool openFlag) async {
    infoData?.openMsg = openFlag;
    //调接口
    ApiMine.api.setOpenMsg(openFlag);
    notifyListeners();
  }


}
