import 'dart:convert';

import 'package:starfish_http/http/socket/socket_resp.dart';
import 'package:web_socket_channel/web_socket_channel.dart';

class WebSocketInstance {
  WebSocketInstance._();

  static WebSocketInstance instance = WebSocketInstance._();

  WebSocketChannel? socketChannel;

  void connectSocket() {
    socketChannel =
        WebSocketChannel.connect(Uri.parse("ws://172.25.12.108:9025/api/websocket/12345678"));
    var stream = socketChannel?.stream;
    stream?.listen((event) {
      print("WebSocketInstance event=$event");
      try {
        //心跳
        var socketResp = SocketResp.fromJson(jsonDecode(event));
        if (socketResp.code?.toInt() == 333) {
          sendMessage(event);
        }else if(socketResp.code?.toInt() == 666){

        }
      } catch (e) {
        print("WebSocketInstance e=$e");
      }
    });
  }

  void sendMessage(dynamic data) {
    socketChannel?.sink.add(data);
  }

  void close() {
    socketChannel?.sink.close();
  }
}