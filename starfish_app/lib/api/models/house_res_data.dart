/// id : 1
/// image : "https://n.sinaimg.cn/sinacn16/112/w1557h955/20180510/7270-haichqz7292785.jpg"
/// title : "翻斗花园二期押一付三"
/// subTitle : "近地铁 押一付三一室一厅"
/// rent : 3000
/// tagList : [{"id":1,"houseResId":1,"name":"近地铁","type":"0","createTime":"2024-05-12T16:00:00.000+00:00","status":0},{"id":2,"houseResId":1,"name":"在线签约","type":"0","createTime":"2024-05-12T16:00:00.000+00:00","status":0},{"id":3,"houseResId":1,"name":"整租","type":"1","createTime":"2024-05-12T16:00:00.000+00:00","status":0},{"id":4,"houseResId":1,"name":"不要钱22","type":"0","createTime":"2024-05-12T16:00:00.000+00:00","status":0},{"id":6,"houseResId":1,"name":"不要钱2","type":"0","createTime":null,"status":0}]

///房源列表数据，收藏接口也是这个实体
class HouseResListData {
  List<HouseResData>? houseResList;

  HouseResListData.fromJson(dynamic json) {
    houseResList = [];
    if (json is List) {
      for (var child in json) {
        houseResList?.add(HouseResData.fromJson(child));
      }
    }
  }
}

class HouseResData {
  HouseResData({
    this.id,
    this.image,
    this.title,
    this.subTitle,
    this.rent,
    this.tagList,
  });

  HouseResData.fromJson(dynamic json) {
    id = json['id'];
    image = json['image'];
    title = json['title'];
    subTitle = json['subTitle'];
    rent = json['rent'];
    if (json['tagList'] != null) {
      tagList = [];
      json['tagList'].forEach((v) {
        tagList?.add(TagList.fromJson(v));
      });
    }
  }

  num? id;
  String? image;
  String? title;
  String? subTitle;
  num? rent;
  List<TagList>? tagList;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['id'] = id;
    map['image'] = image;
    map['title'] = title;
    map['subTitle'] = subTitle;
    map['rent'] = rent;
    if (tagList != null) {
      map['tagList'] = tagList?.map((v) => v.toJson()).toList();
    }
    return map;
  }
}

/// id : 1
/// houseResId : 1
/// name : "近地铁"
/// type : "0"
/// createTime : "2024-05-12T16:00:00.000+00:00"
/// status : 0

class TagList {
  TagList({
    this.id,
    this.houseResId,
    this.name,
    this.type,
    this.createTime,
    this.status,
  });

  TagList.fromJson(dynamic json) {
    id = json['id'];
    houseResId = json['houseResId'];
    name = json['name'];
    type = json['type'];
    createTime = json['createTime'];
    status = json['status'];
  }

  num? id;
  num? houseResId;
  String? name;
  String? type;
  String? createTime;
  num? status;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['id'] = id;
    map['houseResId'] = houseResId;
    map['name'] = name;
    map['type'] = type;
    map['createTime'] = createTime;
    map['status'] = status;
    return map;
  }
}
