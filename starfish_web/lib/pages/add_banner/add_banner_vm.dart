import 'package:flutter/cupertino.dart';
import 'package:oktoast/oktoast.dart';
import 'package:starfish_web/repository/api.dart';

import '../../repository/data/banner_list_data.dart';

class AddBannerViewModel with ChangeNotifier {
  List<BannerListItemData>? bannerList;

  BannerListItemData? currentItem;

  TextEditingController? inputImgUrl = TextEditingController(text: "");
  TextEditingController? inputLink = TextEditingController(text: "");
  TextEditingController? inputActName = TextEditingController(text: "");

  ///banner列表
  Future getBannerList() async {
    bannerList = await Api.api.bannerList();
    notifyListeners();
  }

  Future delBanner(String? id) async {
    bool? success = await Api.api.deleteBanner(id);
    if (success == true) {
      //刷新数据
      getBannerList();
    }
  }

  Future addBanner() async {
    if (inputImgUrl?.text.isNotEmpty == true &&
        inputLink?.text.isNotEmpty == true &&
        inputActName?.text.isNotEmpty == true) {
      BannerListItemData? itemData = BannerListItemData(
        imgurl: inputImgUrl?.text,
        link:  inputLink?.text,
        activename: inputActName?.text,
        type: 0,
        status: 0
      );
      bool? success = await Api.api.addBanner(itemData);
      if (success == true) {
        //刷新数据
        getBannerList();
      }
    } else {
      showToast("输入不能为空");
    }
  }

  Future updateBanner() async {
    if (inputImgUrl?.text.isEmpty == true &&
        inputLink?.text.isEmpty == true &&
        inputActName?.text.isEmpty == true) {
      showToast("输入不能为空");
      return;
    }
    if (inputImgUrl?.text.isNotEmpty == true) {
      currentItem?.imgurl = inputImgUrl?.text;
    }
    if (inputActName?.text.isNotEmpty == true) {
      currentItem?.activename = inputActName?.text;
    }
    if (inputLink?.text.isNotEmpty == true) {
      currentItem?.link = inputLink?.text;
    }
    bool? success = await Api.api.updateBanner(currentItem);

    if (success == true) {
      //刷新数据
      getBannerList();
    }
  }

  void setCurrItem(BannerListItemData? item) {
    currentItem = item;
    inputLink?.text = currentItem?.link ?? "";
    inputImgUrl?.text = currentItem?.imgurl ?? "";
    inputActName?.text = currentItem?.activename ?? "";
    notifyListeners();
  }

  void clearCurrItem() {
    currentItem = null;
    inputLink?.text = "";
    inputImgUrl?.text = "";
    inputActName?.text = "";
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
