/// data : {"banner":[{"imageUrl":"https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg","id":"1"},{"imageUrl":"https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png","id":"2"},{"imageUrl":"https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg","id":"3"},{"imageUrl":"https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png","id":"4"}],"betterChoice":[{"imageUrl":"https://n.sinaimg.cn/sinacn16/112/w1557h955/20180510/7270-haichqz7292785.jpg","id":"1","title":"精品装修","subTitle":"舒适的环境"},{"imageUrl":"https://pic.616pic.com/photoone/00/06/56/61975de20f1487757.jpg","id":"1","title":"温馨小窝","subTitle":"倦怠的生活"},{"imageUrl":"https://pic.616pic.com/photoone/00/06/37/61975c8c74872813.jpg","id":"1","title":"大牌商圈","subTitle":"选择更多"}]}

class HomeBannerData {
  HomeBannerData({
    this.data,
  });

  HomeBannerData.fromJson(Map<String, dynamic>? json) {
    data = json?['data'] != null ? HomeData.fromJson(json?['data']) : null;
  }

  HomeData? data;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    if (data != null) {
      map['data'] = data?.toJson();
    }
    return map;
  }
}

/// banner : [{"imageUrl":"https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg","id":"1"},{"imageUrl":"https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png","id":"2"},{"imageUrl":"https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg","id":"3"},{"imageUrl":"https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png","id":"4"}]
/// betterChoice : [{"imageUrl":"https://n.sinaimg.cn/sinacn16/112/w1557h955/20180510/7270-haichqz7292785.jpg","id":"1","title":"精品装修","subTitle":"舒适的环境"},{"imageUrl":"https://pic.616pic.com/photoone/00/06/56/61975de20f1487757.jpg","id":"1","title":"温馨小窝","subTitle":"倦怠的生活"},{"imageUrl":"https://pic.616pic.com/photoone/00/06/37/61975c8c74872813.jpg","id":"1","title":"大牌商圈","subTitle":"选择更多"}]

class HomeData {
  HomeData({
    this.banner,
    this.betterChoice,
  });

  HomeData.fromJson(Map<String, dynamic>? json) {
    if (json?['banner'] != null) {
      banner = [];
      json?['banner'].forEach((v) {
        banner?.add(HomeBanner.fromJson(v));
      });
    }
    if (json?['betterChoice'] != null) {
      betterChoice = [];
      json?['betterChoice'].forEach((v) {
        betterChoice?.add(BetterChoice.fromJson(v));
      });
    }
  }

  List<HomeBanner>? banner;
  List<BetterChoice>? betterChoice;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    if (banner != null) {
      map['banner'] = banner?.map((v) => v.toJson()).toList();
    }
    if (betterChoice != null) {
      map['betterChoice'] = betterChoice?.map((v) => v.toJson()).toList();
    }
    return map;
  }
}

/// imageUrl : "https://n.sinaimg.cn/sinacn16/112/w1557h955/20180510/7270-haichqz7292785.jpg"
/// id : "1"
/// title : "精品装修"
/// subTitle : "舒适的环境"

class BetterChoice {
  BetterChoice({
    this.imageUrl,
    this.id,
    this.title,
    this.subTitle,
  });

  BetterChoice.fromJson(Map<String, dynamic>? json) {
    imageUrl = json?['imageUrl'];
    id = json?['id'];
    title = json?['title'];
    subTitle = json?['subTitle'];
  }

  String? imageUrl;
  String? id;
  String? title;
  String? subTitle;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['imageUrl'] = imageUrl;
    map['id'] = id;
    map['title'] = title;
    map['subTitle'] = subTitle;
    return map;
  }
}

/// imageUrl : "https://q7.itc.cn/images01/20240312/ae5f3266aeb6408db22ad354f1168883.jpeg"
/// id : "1"

class HomeBanner {
  HomeBanner({
    this.imageUrl,
    this.id,
  });

  HomeBanner.fromJson(Map<String, dynamic>? json) {
    imageUrl = json?['imageUrl'];
    id = json?['id'];
  }

  String? imageUrl;
  String? id;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['imageUrl'] = imageUrl;
    map['id'] = id;
    return map;
  }
}
