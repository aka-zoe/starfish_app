
class DateTimeModel {
  final DateTime date;
  final String displayDate;
  final List<String> times;

  DateTimeModel({required this.date})
      : displayDate = '${date.month.toString().padLeft(2, '0')}月${date.day.toString().padLeft(2, '0')}日 ${_weekdayString(date.weekday)}',
        times = List.generate(48, (index) => '${(index ~/ 2).toString().padLeft(2, '0')}:${(index % 2) * 30 == 0 ? '00' : '30'}');

  static String _weekdayString(int weekday) {
    switch (weekday) {
      case 1:
        return '周一';
      case 2:
        return '周二';
      case 3:
        return '周三';
      case 4:
        return '周四';
      case 5:
        return '周五';
      case 6:
        return '周六';
      case 7:
        return '周日';
      default:
        return '';
    }
  }
}
