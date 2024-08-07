/// id : 3
/// houseresid : 1
/// bookedtime : 1720349604
/// userid : 1
/// bookeduserid : 1
/// userphone : "1001001003"
/// username : "GG3"
/// status : 1

///房源预约记录
class HouseResBookedData {
  List<HouseResBookedItemData>? bookedList;

  HouseResBookedData.fromJson(dynamic json) {
    if (json != null && json is List) {
      bookedList = [];
      for (var item in json) {
        bookedList?.add(HouseResBookedItemData.fromJson(item));
      }
    }
  }
}

class HouseResBookedItemData {
  HouseResBookedItemData({
    this.id,
    this.houseresid,
    this.bookedtime,
    this.userid,
    this.bookeduserid,
    this.userphone,
    this.username,
    this.status,
  });

  HouseResBookedItemData.fromJson(dynamic json) {
    id = json['id'];
    houseresid = json['houseresid'];
    bookedtime = json['bookedtime'];
    userid = json['userid'];
    bookeduserid = json['bookeduserid'];
    userphone = json['userphone'];
    username = json['username'];
    status = json['status'];
  }

  num? id;
  num? houseresid;
  num? bookedtime;
  num? userid;
  num? bookeduserid;
  String? userphone;
  String? username;
  num? status;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['id'] = id;
    map['houseresid'] = houseresid;
    map['bookedtime'] = bookedtime;
    map['userid'] = userid;
    map['bookeduserid'] = bookeduserid;
    map['userphone'] = userphone;
    map['username'] = username;
    map['status'] = status;
    return map;
  }
}
