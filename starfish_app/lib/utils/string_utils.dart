import 'package:flutter/cupertino.dart';

class StringUtils {

  ///限制字符串最大长度显示，超出用...
  static String limitString({required String? content, int? limits = 12}) {
    if (content == null && content?.isEmpty == true) {
      return "";
    }
    try {
      if ((content?.length ?? 0) <= (limits ?? 12)) {
        return content ?? "";
      } else {
        return "${content?.substring(0, limits)}...";
      }
    } catch (err) {
      return "";
    }
  }

  ///校验字符串是否为空
  static bool isEmpty(String? target) {
    return target == null || target == "";
  }

  ///校验输入框字符串是否为空
  static bool isEmptyByTDController(TextEditingController? controller) {
    return isEmpty(controller?.text);
  }
}
