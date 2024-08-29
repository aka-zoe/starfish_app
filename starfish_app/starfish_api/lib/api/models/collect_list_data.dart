/// id : 2
/// collecttype : 1
/// collecttime : 1720349602
/// houseresid : 1
/// newsid : 1
/// userid : 1
/// title : "收藏房源内容标题"
class CollectData {
  List<CollectListData>? collectList;

  CollectData.fromJson(dynamic json) {
    collectList = [];
    if (json is List) {
      for (var child in json) {
        collectList?.add(CollectListData.fromJson(child));
      }
    }
  }
}

class CollectListData {
  CollectListData({
    this.id,
    this.collecttype,
    this.collecttime,
    this.houseresid,
    this.newsid,
    this.userid,
    this.title,
  });

  CollectListData.fromJson(dynamic json) {
    id = json['id'];
    collecttype = json['collecttype'];
    collecttime = json['collecttime'];
    houseresid = json['houseresid'];
    newsid = json['newsid'];
    userid = json['userid'];
    title = json['title'];
  }

  num? id;
  num? collecttype;
  num? collecttime;
  num? houseresid;
  num? newsid;
  num? userid;
  String? title;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['id'] = id;
    map['collecttype'] = collecttype;
    map['collecttime'] = collecttime;
    map['houseresid'] = houseresid;
    map['newsid'] = newsid;
    map['userid'] = userid;
    map['title'] = title;
    return map;
  }
}
