/// message : "success"
/// code : 200
/// content : [{"id":1,"title":"精品装修","subtitle":"舒适的环境","resid":1,"imgurl":"https://n.sinaimg.cn/sinacn16/112/w1557h955/20180510/7270-haichqz7292785.jpg","link":"https://www.baidu.com","type":0,"status":0},{"id":2,"title":"温馨小窝","subtitle":"倦怠的生活","resid":1,"imgurl":"https://pic.616pic.com/photoone/00/06/56/61975de20f1487757.jpg","link":"https://www.baidu.com","type":0,"status":0},{"id":3,"title":"大牌商圈","subtitle":"选择更多","resid":1,"imgurl":"https://pic.616pic.com/photoone/00/06/37/61975c8c74872813.jpg","link":"https://www.baidu.com","type":0,"status":0},{"id":5,"title":"测试标题2222","subtitle":"测试副标题2222","resid":1,"imgurl":"https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg","link":"https://www.baidu.com","type":0,"status":0}]
/// success : true
class BetterChoiceListData {
  List<BetterChoiceData>? choiceList;

  BetterChoiceListData.fromJson(dynamic json) {
    choiceList = [];
    if (json != null && json is List) {
      for (var element in json) {
        choiceList?.add(BetterChoiceData.fromJson(element));
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

