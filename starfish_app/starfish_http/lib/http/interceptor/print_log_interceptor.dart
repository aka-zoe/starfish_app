import 'dart:convert';
import 'dart:developer';

import 'package:dio/dio.dart';

///网络请求与返回信息打印拦截器
class PrintLogInterceptor extends InterceptorsWrapper {
  @override
  void onRequest(RequestOptions options, RequestInterceptorHandler handler) {
    print("\nrequest-------------->");
    options.headers.forEach((key, value) {
      print("请求头信息：$key : ${value.toString()}");
    });
    print("path:${options.uri}");
    print("method:${options.method}");
    try{
      print("data:${jsonEncode(options.data)}");
    }catch(e){
      print("data:${options.data}");
    }

    print("queryParameters:${options.queryParameters.toString()}");
    print("<--------------request\n");
    super.onRequest(options, handler);
  }

  @override
  void onResponse(Response response, ResponseInterceptorHandler handler) {
    print("\nresponse-------------->");
    print("path:${response.realUri}");
    print("headers:${response.headers.toString()}");
    print("statusMessage:${response.statusMessage}");
    print("statusCode:${response.statusCode}");
    print("extra:${response.extra.toString()}");
    try{
      print("data:${jsonEncode(response.data)}");
    }catch(e){
      print("data:${response.data}");
    }
    print("<--------------response\n");
    super.onResponse(response, handler);
  }

  @override
  void onError(DioException err, ErrorInterceptorHandler handler) {
    print("\nonError-------------->");
    print("error:${err.toString()}");
    print("<--------------onError\n");
    super.onError(err, handler);
  }
}
