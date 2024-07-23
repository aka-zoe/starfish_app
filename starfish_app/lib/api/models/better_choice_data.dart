/// id : 1
/// title : "精品装修"
/// subtitle : "舒适的环境"
/// resid : 1
/// imgurl : "https://n.sinaimg.cn/sinacn16/112/w1557h955/20180510/7270-haichqz7292785.jpg"
/// link : "https://www.baidu.com"
/// type : 0
/// status : 0

///首页本期优选数据列表
class BetterChoiceListData {
  List<BetterChoiceData>? choiceList;

  BetterChoiceListData.fromJson(dynamic json) {
    choiceList = [];
    if (json is List) {
      for (var child in json) {
        choiceList?.add(BetterChoiceData.fromJson(child));
      }
    }
  }
}

class BetterChoiceData {
  BetterChoiceData({
    this.id,
    this.title,
    this.subtitle,
    this.resid,
    this.imgurl,
    this.link,
    this.type,
    this.status,
  });

  BetterChoiceData.fromJson(dynamic json) {
    id = json['id'];
    title = json['title'];
    subtitle = json['subtitle'];
    resid = json['resid'];
    imgurl = json['imgurl'];
    link = json['link'];
    type = json['type'];
    status = json['status'];
  }

  num? id;
  String? title;
  String? subtitle;
  num? resid;
  String? imgurl;
  String? link;
  num? type;
  num? status;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['id'] = id;
    map['title'] = title;
    map['subtitle'] = subtitle;
    map['resid'] = resid;
    map['imgurl'] = imgurl;
    map['link'] = link;
    map['type'] = type;
    map['status'] = status;
    return map;
  }
}
