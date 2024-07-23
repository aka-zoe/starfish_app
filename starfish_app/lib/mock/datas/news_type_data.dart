/// data : [{"id":"1","type":"0","title":"租房分期付款套路多 如何防止被骗","author":"大谈房屋知识","date":"2019.08.08","imageList":["https://images.pexels.com/photos/2501965/pexels-photo-2501965.jpeg","https://images.pexels.com/photos/101808/pexels-photo-101808.jpeg","https://images.pexels.com/photos/1396122/pexels-photo-1396122.jpeg"],"singleImage":"","link":"http://www.baidu.com"},{"id":"2","type":"0","title":"租房分期付款套路多 如何防止被骗","author":"大谈房屋知识","date":"2019.08.08","imageList":["https://images.pexels.com/photos/2501965/pexels-photo-2501965.jpeg","https://images.pexels.com/photos/101808/pexels-photo-101808.jpeg","https://images.pexels.com/photos/1396122/pexels-photo-1396122.jpeg"],"singleImage":"","link":"http://www.baidu.com"},{"id":"3","type":"1","title":"租房分期付款套路多 如何防止被骗","author":"大谈房屋知识","date":"2019.08.08","imageList":[],"singleImage":"","link":"http://www.baidu.com"},{"id":"4","type":"1","title":"租房分期付款套路多 如何防止被骗","author":"大谈房屋知识","date":"2019.08.08","imageList":[],"singleImage":"","link":"http://www.baidu.com"},{"id":"5","type":"2","title":"租房分期付款套路多 如何防止被骗","author":"大谈房屋知识","date":"2019.08.08","imageList":[],"singleImage":"https://images.pexels.com/photos/2501965/pexels-photo-2501965.jpeg","link":"http://www.baidu.com"},{"id":"6","type":"1","title":"租房分期付款套路多 如何防止被骗","author":"大谈房屋知识","date":"2019.08.08","imageList":[],"singleImage":"","link":"http://www.baidu.com"}]

class NewsTypeData {
  NewsTypeData({
    this.data,
  });

  NewsTypeData.fromJson(dynamic json) {
    if (json['data'] != null) {
      data = [];
      json['data'].forEach((v) {
        data?.add(NewsTypeListData.fromJson(v));
      });
    }
  }

  List<NewsTypeListData>? data;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    if (data != null) {
      map['data'] = data?.map((v) => v.toJson()).toList();
    }
    return map;
  }
}

/// id : "1"
/// type : "0"
/// title : "租房分期付款套路多 如何防止被骗"
/// author : "大谈房屋知识"
/// date : "2019.08.08"
/// imageList : ["https://images.pexels.com/photos/2501965/pexels-photo-2501965.jpeg","https://images.pexels.com/photos/101808/pexels-photo-101808.jpeg","https://images.pexels.com/photos/1396122/pexels-photo-1396122.jpeg"]
/// singleImage : ""
/// link : "http://www.baidu.com"

class NewsTypeListData {
  NewsTypeListData({
    this.id,
    this.type,
    this.title,
    this.author,
    this.date,
    this.imageList,
    this.singleImage,
    this.link,
  });

  NewsTypeListData.fromJson(dynamic json) {
    id = json['id'];
    type = json['type'];
    title = json['title'];
    author = json['author'];
    date = json['date'];
    imageList = json['imageList'] != null ? json['imageList'].cast<String>() : [];
    singleImage = json['singleImage'];
    link = json['link'];
  }

  String? id;

  //0= 三图类型，1=无图类型，2=单图类型
  String? type;
  String? title;
  String? author;
  String? date;
  List<String>? imageList;
  String? singleImage;
  String? link;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['id'] = id;
    map['type'] = type;
    map['title'] = title;
    map['author'] = author;
    map['date'] = date;
    map['imageList'] = imageList;
    map['singleImage'] = singleImage;
    map['link'] = link;
    return map;
  }
}
