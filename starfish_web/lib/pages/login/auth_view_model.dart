import 'package:flutter/cupertino.dart';
import 'package:oktoast/oktoast.dart';

import '../../constants.dart';

class AuthViewModel with ChangeNotifier {
  String? inputUserName = "";
  String? inputPassword = "";
  String? inputPasswordTwice = "";

  Future<bool> login() async {
    if (inputUserName?.trim().isEmpty == true) {
      showToast("请输入账号");
      return false;
    }

    if (inputPassword?.trim().isEmpty == true) {
      showToast("请输入密码");
      return false;
    }

    // UserInfoModel? userInfo = await WanApi.instance().login(inputUserName, inputPassword);
    // if (userInfo?.username != null) {
    //   SpUtils.saveString(Constants.SP_USER_NAME, userInfo?.username ?? "");
      return true;
    // } else {
    //   showToast("登录异常");
    //   return false;
    // }
  }

  Future<bool> register() async {
    if (inputUserName?.trim().isEmpty == true) {
      showToast("请输入账号");
      return false;
    }

    if (inputPassword?.trim().isEmpty == true) {
      showToast("请输入密码");
      return false;
    }

    if (inputPasswordTwice?.trim().isEmpty == true) {
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
}
