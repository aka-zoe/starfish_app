import 'package:starfish_web/repository/data/user_info_data.dart';

class GlobalInfo {
  GlobalInfo._();

  static GlobalInfo info = GlobalInfo._();

  UserInfoData? _userInfo;

  Future initUser(UserInfoData? userInfo) async {
    _userInfo = userInfo;
  }

  UserInfoData? getUserInfo() {
    return _userInfo;
  }
}
