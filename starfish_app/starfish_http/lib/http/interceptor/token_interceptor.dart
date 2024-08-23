import 'package:dio/dio.dart';
import 'package:starfish_utils/utils/sp_utils.dart';
import 'package:starfish_utils/utils/constants.dart';

class TokenInterceptor extends Interceptor {
  @override
  void onRequest(RequestOptions options, RequestInterceptorHandler handler) async {
    options.headers["token"] = await SpUtils.getString(Constants.SP_TOKEN);
    handler.next(options);
  }
}
