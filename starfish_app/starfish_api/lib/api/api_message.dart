import 'package:dio/dio.dart';
import 'package:starfish_api/api/models/message_data.dart';
import 'package:starfish_http/http/dio_instance.dart';

import 'models/app_news_data.dart';

class ApiMessage {
  ApiMessage._();

  static ApiMessage api = ApiMessage._();

  ///获取消息列表
  Future<MessageListData> getMessages() async {
    Response resp = await DioInstance.instance().post(path: "/message/getMessages");
    return MessageListData.fromJson(resp.data);
  }

  ///删除消息
  Future<bool> deleteMessage(num? id) async {
    Response resp = await DioInstance.instance()
        .post(path: "/message/deleteMessage", queryParameters: {"id": id});
    return takeResp(resp.data);
  }

  ///单条消息已读
  Future<bool> setReadMessage(num? id) async {
    Response resp = await DioInstance.instance()
        .post(path: "/message/setReadMessage", queryParameters: {"id": id});
    return takeResp(resp.data);
  }

  ///全部消息已读
  Future<bool> setAllMessageRead() async {
    Response resp = await DioInstance.instance().post(path: "/message/setAllMessageRead");
    return takeResp(resp.data);
  }

  bool takeResp(dynamic data) {
    if (data != null && data is bool) {
      return data;
    }
    return false;
  }
}
