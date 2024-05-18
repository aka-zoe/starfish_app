import 'package:flutter/cupertino.dart';
import 'package:oktoast/oktoast.dart';
import 'package:starfish_web/repository/api.dart';

import '../../repository/data/banner_list_data.dart';
import '../../repository/data/better_choice_data.dart';

class BetterChoiceViewModel with ChangeNotifier {
  List<BetterChoiceData>? choiceList;

  BetterChoiceData? currentItem;

  TextEditingController? inputTitle = TextEditingController(text: "");
  TextEditingController? inputSubTitle = TextEditingController(text: "");
  TextEditingController? inputLink = TextEditingController(text: "");
  TextEditingController? inputImgUrl = TextEditingController(text: "");

  ///本期优选列表
  Future getBetterChoiceList() async {
    choiceList = await Api.api.betterChoiceList();
    notifyListeners();
  }

  ///删除本期优选
  Future delBanner(String? id) async {
    bool? success = await Api.api.deleteBetterChoice(id);
    if (success == true) {
      //刷新数据
      getBetterChoiceList();
    }
  }

  Future addBetterChoice() async {
    if (inputImgUrl?.text.isNotEmpty == true &&
        inputLink?.text.isNotEmpty == true &&
        inputTitle?.text.isNotEmpty == true&&
        inputSubTitle?.text.isNotEmpty == true) {
      BetterChoiceData? itemData = BetterChoiceData(
        imgurl: inputImgUrl?.text,
        link:  inputLink?.text,
        title: inputTitle?.text,
        subtitle: inputSubTitle?.text,
        resid: 1,
        type: 0,
        status: 0
      );
      bool? success = await Api.api.addBetterChoice(itemData);
      if (success == true) {
        //刷新数据
        getBetterChoiceList();
      }
    } else {
      showToast("输入不能为空");
    }
  }

  Future updateBetterChoice() async {
    if (inputImgUrl?.text.isEmpty == true &&
        inputLink?.text.isEmpty == true &&
        inputTitle?.text.isEmpty == true&&
        inputSubTitle?.text.isEmpty == true) {
      showToast("输入不能为空");
      return;
    }
    if (inputImgUrl?.text.isNotEmpty == true) {
      currentItem?.imgurl = inputImgUrl?.text;
    }
    if (inputTitle?.text.isNotEmpty == true) {
      currentItem?.title = inputTitle?.text;
    }
    if (inputSubTitle?.text.isNotEmpty == true) {
      currentItem?.subtitle = inputSubTitle?.text;
    }
    if (inputLink?.text.isNotEmpty == true) {
      currentItem?.link = inputLink?.text;
    }
    bool? success = await Api.api.updateBetterChoice(currentItem);

    if (success == true) {
      //刷新数据
      getBetterChoiceList();
    }
  }

  void setCurrItem(BetterChoiceData? item) {
    currentItem = item;
    inputLink?.text = currentItem?.link ?? "";
    inputImgUrl?.text = currentItem?.imgurl ?? "";
    inputTitle?.text = currentItem?.title ?? "";
    inputSubTitle?.text = currentItem?.subtitle ?? "";
    notifyListeners();
  }

  void clearCurrItem() {
    currentItem = null;
    inputLink?.text = "";
    inputImgUrl?.text = "";
    inputTitle?.text = "";
    inputSubTitle?.text = "";
    notifyListeners();
  }

  String getStatus(num? status) {
    switch (status) {
      case 0:
        return "正常";
      case 1:
        return "停用";
      case -1:
        return "删除";
      default:
        return "";
    }
  }
}
