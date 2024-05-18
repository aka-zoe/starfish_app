/// id : 1
/// imgurl : "https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg"
/// link : "https://www.baidu.com"
/// type : 0
/// activename : "搞笑活动"
/// status : 0

class BannerListData {
  List<BannerListItemData>? bannerList;

  BannerListData.fromJson(dynamic json) {
    bannerList = [];
    if (json != null && json is List) {
      for (var element in json) {
        bannerList?.add(BannerListItemData.fromJson(element));
      }
    }
  }
}

class BannerListItemData {
  BannerListItemData({
    this.id,
    this.imgurl,
    this.link,
    this.type,
    this.activename,
    this.status,
  });

  BannerListItemData.fromJson(Map<String, dynamic>? json) {
    id = json?['id'];
    imgurl = json?['imgurl'];
    link = json?['link'];
    type = json?['type'];
    activename = json?['activename'];
    status = json?['status'];
  }

  num? id;

  //图片地址
  String? imgurl;

  //活动链接
  String? link;

  //banner类型
  num? type;

  //活动名称
  String? activename;

  //状态：0=正常 1=停用 -1=删除
  num? status;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['id'] = id;
    map['imgurl'] = imgurl;
    map['link'] = link;
    map['type'] = type;
    map['activename'] = activename;
    map['status'] = status;
    return map;
  }
}
