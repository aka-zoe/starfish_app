import 'package:flutter/widgets.dart';
import 'package:starfish_api/api/api_house.dart';
import 'package:starfish_api/api/models/my_booked_list_data.dart';

class MyBookedViewModel with ChangeNotifier {
  List<MyBookedData>? bookedList;

  ///获取我的房源预约记录
  Future getBookedList() async {
    MyBookedListData data = await ApiHouse.api.bookedHouseList();
    bookedList = data.bookedList ?? [];
    notifyListeners();
  }

  ///1=待处理、2=超时未处理、3=已处理、4=已关闭）
  String getStatus(num? status) {
    switch (status) {
      case 1:
        return "待处理";
      case 2:
        return "超时未处理";
      case 3:
        return "已处理";
      case 4:
        return "已关闭";
      default:
        return "";
    }
  }

}
