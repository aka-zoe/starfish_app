/// id : 1
/// userid : 1
/// title : "消息标题"
/// subtitle : "副标题：北京市场行情1北京市场"
/// content : "消息内容详细内容"
/// createtime : 1720349602
/// status : 1
class MessageListData {
  List<MessageData>? messageList;

  MessageListData.fromJson(dynamic json) {
    messageList = [];
    if (json is List) {
      for (var child in json) {
        messageList?.add(MessageData.fromJson(child));
      }
    }
  }
}

class MessageData {
  MessageData({
    this.id,
    this.userid,
    this.title,
    this.subtitle,
    this.content,
    this.createtime,
    this.status,
  });

  MessageData.fromJson(dynamic json) {
    id = json['id'];
    userid = json['userid'];
    title = json['title'];
    subtitle = json['subtitle'];
    content = json['content'];
    createtime = json['createtime'];
    status = json['status'];
  }

  num? id;
  num? userid;
  String? title;
  String? subtitle;
  String? content;
  num? createtime;
  num? status;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['id'] = id;
    map['userid'] = userid;
    map['title'] = title;
    map['subtitle'] = subtitle;
    map['content'] = content;
    map['createtime'] = createtime;
    map['status'] = status;
    return map;
  }
}
