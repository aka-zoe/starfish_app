/// code : 200
/// message : ""
/// body : "conn_success"

class SocketResp {
  SocketResp({
    this.code,
    this.message,
    this.body,
  });

  SocketResp.fromJson(dynamic json) {
    if (json != null && json is Map) {
      code = json['code'];
      message = json['message'];
      body = json['body'];
    }
  }

  num? code;
  String? message;
  dynamic body;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['code'] = code;
    map['message'] = message;
    map['body'] = body;
    return map;
  }
}
