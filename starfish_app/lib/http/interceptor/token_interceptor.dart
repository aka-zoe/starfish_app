
import 'package:dio/dio.dart';

import '../../constants.dart';
import '../../utils/sp_utils.dart';

class TokenInterceptor extends Interceptor {
  @override
  void onRequest(RequestOptions options, RequestInterceptorHandler handler) async {
    options.headers["token"] = await SpUtils.getString(Constants.SP_TOKEN);
    handler.next(options);
  }
}
