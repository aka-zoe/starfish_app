/// message : "success"
/// code : 200
/// content : null
/// success : true

class BaseData {
  BaseData({
    this.message,
    this.code,
    this.content,
    this.success,
  });

  BaseData.fromJson(dynamic json) {
    message = json['message'];
    code = json['code'];
    content = json['content'];
    success = json['success'];
  }

  String? message;
  num? code;
  dynamic content;
  bool? success;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['message'] = message;
    map['code'] = code;
    map['content'] = content;
    map['success'] = success;
    return map;
  }
}
