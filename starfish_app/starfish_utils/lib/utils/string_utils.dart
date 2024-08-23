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
  static bool isEmptyByTEditController(TextEditingController? controller) {
    return isEmpty(controller?.text);
  }

  ///默认取数组第一个下标，传入index取指定下标值
  static String takeStrForList(List<String?>? imageList, {int? index}) {
    if (imageList == null || imageList.isEmpty == true) {
      return "";
    }
    if (index == null) {
      return imageList[0] ?? "";
    } else {
      if ((imageList.length - 1) >= index) {
        return imageList[index] ?? "";
      } else {
        return "";
      }
    }
  }
}
