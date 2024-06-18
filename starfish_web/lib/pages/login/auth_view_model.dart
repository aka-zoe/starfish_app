import 'package:flutter/cupertino.dart';
import 'package:oktoast/oktoast.dart';
import 'package:starfish_web/repository/api.dart';
import 'package:starfish_web/repository/data/user_info_data.dart';
import 'package:starfish_web/utils/global_info.dart';

class AuthViewModel with ChangeNotifier {
  TextEditingController inputUserName = TextEditingController(text: "Zoe");
  TextEditingController inputPassword = TextEditingController(text: "123456");
  TextEditingController inputPasswordTwice = TextEditingController();
  bool rememberMe = false;

  Future<bool> login() async {
    if (inputUserName.text.trim().isEmpty == true) {
      showToast("请输入账号");
      return false;
    }

    if (inputPassword.text.trim().isEmpty == true) {
      showToast("请输入密码");
      return false;
    }
    UserInfoData userInfo = await Api.api.login(inputUserName.text, inputPassword.text);
    if (userInfo.token != null && userInfo.token?.isNotEmpty == true) {
      GlobalInfo.info.initUser(userInfo);
      return true;
    }
    return false;
  }

  Future<bool> register() async {
    if (inputUserName.text.trim().isEmpty == true) {
      showToast("请输入账号");
      return false;
    }

    if (inputPassword.text.trim().isEmpty == true) {
      showToast("请输入密码");
      return false;
    }

    if (inputPasswordTwice.text.trim().isEmpty == true) {
      showToast("请再次输入密码");
      return false;
    }
    // UserInfoModel? userInfo =
    //     await WanApi.instance().register(inputUserName, inputPassword, inputPasswordTwice);
    // if (userInfo?.username != null) {
    return true;
    // } else {
    //   showToast("注册异常");
    //   return false;
    // }
  }

  void setRemember(bool value){
    rememberMe = value;
    notifyListeners();
  }
}
