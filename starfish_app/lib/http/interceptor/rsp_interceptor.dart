import 'package:dio/dio.dart';
import 'package:oktoast/oktoast.dart';
import 'package:starfish_tenement_app/http/base_model.dart';

///处理返回值拦截器
class RspInterceptor extends Interceptor {
  @override
  void onResponse(Response response, ResponseInterceptorHandler handler) {
    if (response.statusCode == 200) {
      try {
        var baseData = BaseModel.fromJson(response.data);
        if (baseData.code != 200) {
          showToast(baseData.message ?? "系统错误");
        }
        handler.next(Response(requestOptions: response.requestOptions, data: baseData.content));
      } catch (e) {
        handler.reject(DioException(requestOptions: response.requestOptions));
      }
    } else {
      handler.reject(DioException(requestOptions: response.requestOptions));
    }
  }
}
