/// bookedCount : 6
/// collectHouseCount : 0
/// collectNewsCount : 0
/// unreadMsgCount : 0

///当前用户相关的APP信息
class AppInfoData {
  AppInfoData({
      this.bookedCount,
      this.collectHouseCount,
      this.collectNewsCount,
      this.unreadMsgCount,
      this.openMsg,
  });

  AppInfoData.fromJson(dynamic json) {
    bookedCount = json['bookedCount'];
    collectHouseCount = json['collectHouseCount'];
    collectNewsCount = json['collectNewsCount'];
    unreadMsgCount = json['unreadMsgCount'];
    openMsg = json['openMsg'];
  }
  num? bookedCount;
  num? collectHouseCount;
  num? collectNewsCount;
  num? unreadMsgCount;
  bool? openMsg;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['bookedCount'] = bookedCount;
    map['collectHouseCount'] = collectHouseCount;
    map['collectNewsCount'] = collectNewsCount;
    map['unreadMsgCount'] = unreadMsgCount;
    map['openMsg'] = openMsg;
    return map;
  }

}
