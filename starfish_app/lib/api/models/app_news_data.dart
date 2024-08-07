/// id : 2
/// title : "北京市场行情1"
/// subtitle : "副标题：北京市场行情1北京市场行情1北京市场行情1北京市场行情1"
/// type : 1
/// tag : "房产新闻"
/// dianzan : 100
/// pinglun : 22
/// imageurl : "https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg"
/// contenturl : "https://juejin.cn/post/7107608301017251876"
/// createtime : 1720349602
/// operationtime : 1720349602
/// createby : 1
/// editby : 1
/// status : 1

///APP资讯返回数据
class AppNewsData {
  List<AppNewsItemData>? newList;

  AppNewsData.fromJson(dynamic json) {
    if (json != null && json is List) {
      newList = [];
      for (var item in json) {
        newList?.add(AppNewsItemData.fromJson(item));
      }
    }
  }
}

class AppNewsItemData {
  AppNewsItemData({
    this.id,
    this.title,
    this.subtitle,
    this.type,
    this.tag,
    this.dianzan,
    this.pinglun,
    this.imageurl,
    this.contenturl,
    this.createtime,
    this.operationtime,
    this.createby,
    this.editby,
    this.status,
  });

  AppNewsItemData.fromJson(dynamic json) {
    id = json['id'];
    title = json['title'];
    subtitle = json['subtitle'];
    type = json['type'];
    tag = json['tag'];
    dianzan = json['dianzan'];
    pinglun = json['pinglun'];
    imageurl = json['imageurl'];
    contenturl = json['contenturl'];
    createtime = json['createtime'];
    operationtime = json['operationtime'];
    createby = json['createby'];
    editby = json['editby'];
    status = json['status'];
  }

  num? id;
  String? title;
  String? subtitle;
  num? type;
  String? tag;
  num? dianzan;
  num? pinglun;
  String? imageurl;
  String? contenturl;
  num? createtime;
  num? operationtime;
  num? createby;
  num? editby;
  num? status;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['id'] = id;
    map['title'] = title;
    map['subtitle'] = subtitle;
    map['type'] = type;
    map['tag'] = tag;
    map['dianzan'] = dianzan;
    map['pinglun'] = pinglun;
    map['imageurl'] = imageurl;
    map['contenturl'] = contenturl;
    map['createtime'] = createtime;
    map['operationtime'] = operationtime;
    map['createby'] = createby;
    map['editby'] = editby;
    map['status'] = status;
    return map;
  }
}
