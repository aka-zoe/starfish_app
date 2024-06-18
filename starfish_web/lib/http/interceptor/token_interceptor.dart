import 'package:dio/dio.dart';
import 'package:starfish_web/utils/global_info.dart';

///将token添加到请求头中
class TokenInterceptor extends Interceptor {
  @override
  void onRequest(RequestOptions options, RequestInterceptorHandler handler) {
    options.headers["token"] = GlobalInfo.info.getUserInfo()?.token;
    handler.next(options);
  }
}
