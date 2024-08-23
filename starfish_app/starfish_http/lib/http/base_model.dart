class BaseModel<T> {
  T? content;
  int? code;
  String? message;
  bool? success;

  BaseModel.fromJson(dynamic json) {
    content = json['content'];
    code = json['code'];
    message = json['message'];
    success = json['success'];
  }
}
