import 'package:flustars/flustars.dart';
import 'package:flutter/widgets.dart';
import 'package:oktoast/oktoast.dart';
import 'package:starfish_api/api/api_house.dart';
import 'package:starfish_utils/utils/string_utils.dart';

class BookedHouseViewModel with ChangeNotifier {
  num? selectBookedDate = 0;
  bool editUserName = false;
  TextEditingController phoneInputController = TextEditingController(text: "13030363100");
  TextEditingController nameInputController = TextEditingController(text: "");

  void setSelectDate(String date) {
    var dateTime = DateUtil.getDateTime(date);
    selectBookedDate = dateTime?.millisecondsSinceEpoch;
    // print("setSelectDate selectBookedDate=$selectBookedDate");
  }

  void changeUserName() {
    editUserName = !editUserName;
    notifyListeners();
  }

  ///提交预约
  Future<bool> submitBooked({
    num? houseresid,
    num? bookeduserid,
  }) async {
    if (StringUtils.isEmptyByTEditController(phoneInputController) ||
        StringUtils.isEmptyByTEditController(nameInputController)) {
      showToast("请检查联系方式和姓名");
      return false;
    }
    return ApiHouse.api.submitBookedHouse(
        houseresid: houseresid,
        bookedtime: selectBookedDate,
        bookeduserid: bookeduserid,
        userphone: phoneInputController.text,
        username: nameInputController.text);
  }
}
