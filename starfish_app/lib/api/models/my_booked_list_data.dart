/// id : 6
/// bookedtime : 1723046400000
/// houseName : "翻斗花园三期32幢三室一厅"
/// status : 1

///我的房源预约列表记录
class MyBookedListData {
  List<MyBookedData>? bookedList;

  MyBookedListData.fromJson(dynamic json) {
    bookedList = [];
    if (json is List) {
      for (var child in json) {
        bookedList?.add(MyBookedData.fromJson(child));
      }
    }
  }
}

class MyBookedData {
  MyBookedData({
    this.id,
    this.bookedtime,
    this.houseName,
    this.status,
  });

  MyBookedData.fromJson(dynamic json) {
    id = json['id'];
    bookedtime = json['bookedtime'];
    houseName = json['houseName'];
    status = json['status'];
  }

  num? id;
  num? bookedtime;
  String? houseName;
  num? status;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['id'] = id;
    map['bookedtime'] = bookedtime;
    map['houseName'] = houseName;
    map['status'] = status;
    return map;
  }
}
