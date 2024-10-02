import 'package:flutter/cupertino.dart';
import 'package:oktoast/oktoast.dart';
import 'package:starfish_common_ui/common_ui/dialog/loading.dart';
import 'package:starfish_tenement_app/constants.dart';
import 'package:starfish_utils/utils/global_info.dart';
import 'package:starfish_utils/utils/sp_utils.dart';
import 'package:starfish_utils/utils/string_utils.dart';
import 'package:starfish_api/api/api_auth.dart';
class AuthViewModel with ChangeNotifier {
  //1=显示登录页 2=显示注册页 3=默认页
  int uiType = 3;

  //软键盘是否弹出
  bool keyboardShow = false;

  TextEditingController inputName = TextEditingController(text: "admin");
  TextEditingController inputPwd = TextEditingController(text: "123456");
  TextEditingController inputRePwd = TextEditingController(text: "123456");

  Future<bool> checkAutoLogin() async {
    String? userName = await SpUtils.getString(Constants.SP_USER_NAME);
    String? userPwd = await SpUtils.getString(Constants.SP_USER_PWD);
    if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(userPwd)) {
      inputName.text = userName ?? "";
      inputPwd.text = userPwd ?? "";
      return await login(true);
    }
    return false;
  }

  ///登录
  Future<bool> login(bool autoCheck) async {
    Loading.showLoading();
    if (StringUtils.isEmptyByTEditController(inputName) ||
        StringUtils.isEmptyByTEditController(inputPwd)) {
      if (!autoCheck) {
        showToast("请检查用户名或密码");
      }
      Loading.dismissAll();
      return false;
    }
    var userInfo = await ApiAuth.api.login(name: inputName.text, password: inputPwd.text);
    if (userInfo != null && !StringUtils.isEmpty(userInfo.token)) {
      //登录成功后保存token和用户名
      await SpUtils.saveString(Constants.SP_TOKEN, userInfo.token ?? "");
      await SpUtils.saveString(Constants.SP_USER_NAME, userInfo.name ?? "");
      await SpUtils.saveString(Constants.SP_USER_PWD, userInfo.password ?? "");
      //添加缓存
      GlobalInfo.info.setUser(userInfo);
      ApiAuth.api.bindPushToken();
      Loading.dismissAll();
      return true;
    }
    Loading.dismissAll();
    return false;
  }

  ///注册
  Future register() async {
    Loading.showLoading();
    if (StringUtils.isEmptyByTEditController(inputName) ||
        StringUtils.isEmptyByTEditController(inputPwd) ||
        StringUtils.isEmptyByTEditController(inputRePwd)) {
      showToast("请检查用户名或密码");
      Loading.dismissAll();
    }
    //调接口注册
    var success = await ApiAuth.api
        .register(name: inputName.text, password: inputPwd.text, rePassword: inputRePwd.text);
    Loading.dismissAll();
    if (success) {
      showToast("注册成功");
      //显示登录ui
      changeUi(1);
    } else {
      showToast("注册失败");
    }
  }

  ///1=显示登录页 2=显示注册页 3=默认页
  void changeUi(int uiType) {
    this.uiType = uiType;
    notifyListeners();
  }

  ///当软键盘弹出或者收起时更新
  void setKeyboardStatus(bool show) {
    keyboardShow = show;
    notifyListeners();
  }
}
