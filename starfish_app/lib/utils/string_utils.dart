class StringUtils {
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
}
