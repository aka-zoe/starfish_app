
class NewsBannerData {
  NewsBannerData({
    this.data,
  });

  NewsBannerData.fromJson(Map<String,dynamic>? json) {
    data = json?['data'] != null ? NewsBannerListData.fromJson(json?['data']) : null;
  }

  NewsBannerListData? data;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    if (data != null) {
      map['data'] = data?.toJson();
    }
    return map;
  }
}

class NewsBannerListData {
  NewsBannerListData({
    this.banner,
  });

  NewsBannerListData.fromJson(Map<String,dynamic>? json) {
    if (json?['banner'] != null && json?['banner'] is List) {
      banner = [];
      json?['banner'].forEach((v) {
        banner?.add(NewsBanner.fromJson(v));
      });
    } else {
      banner = [];
    }
  }

  List<NewsBanner>? banner;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    if (banner != null) {
      map['banner'] = banner?.map((v) => v.toJson()).toList();
    }
    return map;
  }
}

class NewsBanner {
  NewsBanner({
    this.imageUrl,
    this.id,
    this.title,
    this.subTitle,
    this.content,
    this.link,
  });

  NewsBanner.fromJson(Map<String,dynamic>? json) {
    imageUrl = json?['imageUrl'];
    id = json?['id'];
    title = json?['title'];
    subTitle = json?['subTitle'];
    content = json?['content'];
    link = json?['link'];
  }

  String? imageUrl;
  String? id;
  String? title;
  String? subTitle;
  String? content;
  String? link;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['imageUrl'] = imageUrl;
    map['id'] = id;
    map['title'] = title;
    map['subTitle'] = subTitle;
    map['content'] = content;
    map['link'] = link;
    return map;
  }
}
