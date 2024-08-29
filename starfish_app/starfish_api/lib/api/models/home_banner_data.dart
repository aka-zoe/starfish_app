/// id : 1
/// imgurl : "https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg"
/// link : "https://www.baidu.com"
/// type : 0
/// activename : "搞笑活动"
/// status : 0

///首页banner数据列表
class HomeBannerListData {
  List<HomeBannerData>? bannerList;

  HomeBannerListData.fromJson(dynamic json) {
    bannerList = [];
    if (json is List) {
      for (var child in json) {
        bannerList?.add(HomeBannerData.fromJson(child));
      }
    }
  }
}

class HomeBannerData {
  HomeBannerData({
    this.id,
    this.imgurl,
    this.link,
    this.type,
    this.activename,
    this.status,
  });

  HomeBannerData.fromJson(dynamic json) {
    id = json['id'];
    imgurl = json['imgurl'];
    link = json['link'];
    type = json['type'];
    activename = json['activename'];
    status = json['status'];
  }

  num? id;
  String? imgurl;
  String? link;
  num? type;
  String? activename;
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
