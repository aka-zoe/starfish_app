import 'package:shelf/shelf_io.dart' as shelf_io;
import 'package:shelf_proxy/shelf_proxy.dart';

Future<void> main() async {
  /// 输入你想要请求的api网关
  var reqHandle = proxyHandler("http://192.168.3.4:9900");

  /// 绑定本地端口，4500，转发到真正的服务器中
  var server = await shelf_io.serve(reqHandle, 'localhost', 4500);

  // 这里设置请求策略，允许所有
  server.defaultResponseHeaders.add('Access-Control-Allow-Origin', '*');
  server.defaultResponseHeaders.add('Access-Control-Allow-Credentials', true);
  print('Serving at http://${server.address.host}:${server.port}');
}
