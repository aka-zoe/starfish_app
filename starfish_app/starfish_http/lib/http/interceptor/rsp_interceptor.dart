import 'package:dio/dio.dart';
import 'package:oktoast/oktoast.dart';
import 'package:starfish_http/http/base_model.dart';
import 'package:starfish_route/route/route_utils.dart';
import 'package:starfish_route/route/route_path.dart';

///处理返回值拦截器
class RspInterceptor extends Interceptor {
  @override
  void onResponse(Response response, ResponseInterceptorHandler handler) {
    if (response.statusCode == 200) {
      try {
        var baseData = BaseModel.fromJson(response.data);

        int? code = baseData.code;
        if (code == null) {
          handler.reject(DioException(requestOptions: response.requestOptions));
        } else {
          if (code == 200) {
            handler.next(Response(requestOptions: response.requestOptions, data: baseData.content));
          } else if (code == 210 &&
              response.requestOptions.path.contains("getAppInfo") == false &&
              response.requestOptions.path.contains("bindToken") == false &&
              response.requestOptions.path.contains("getImSign") == false) {
            //需要登录
            handler.reject(DioException(requestOptions: response.requestOptions));
            showToast(baseData.message ?? "系统错误");
            RouteUtils.pushForNamed(RouteUtils.context, RoutePath.auth);
          } else {
            //其他错误
            if (response.requestOptions.path.contains("getAppInfo") == false) {
              showToast(baseData.message ?? "系统错误");
            }
            handler.reject(DioException(requestOptions: response.requestOptions));
          }
        }
      } catch (e) {
        handler.reject(DioException(requestOptions: response.requestOptions));
      }
    } else {
      handler.reject(DioException(requestOptions: response.requestOptions));
    }
  }
}
