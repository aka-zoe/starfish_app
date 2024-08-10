import 'package:flustars/flustars.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/common_ui/title/app_text.dart';

typedef DateTimeSelectBuilder = Function(String date, String time);

///房源预约时间选择组件
class DateTimeSelector extends StatefulWidget {
  const DateTimeSelector({super.key, this.builder});

  final DateTimeSelectBuilder? builder;

  @override
  _DateTimeSelectorState createState() => _DateTimeSelectorState();
}

class _DateTimeSelectorState extends State<DateTimeSelector> {
  final List<DateTimeModel> dateTimeModels = generateDateTimeModels();
  int selectedDateIndex = 0;
  int selectedTimeIndex = 0;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();

    if (widget.builder != null) {
      WidgetsBinding.instance.addPostFrameCallback((timeStamp) {
        _dateTimeBuild();
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Container(
        height: 150.h,
        child: Row(crossAxisAlignment: CrossAxisAlignment.center, children: [
          20.horizontalSpace,
          Image.asset("assets/images/icon_red_arrow_right.png", width: 12.w, height: 10.h),
          Expanded(flex: 3, child: _leftDateListWidget()),
          Expanded(flex: 2, child: _rightTimeListWidget()),
          Image.asset("assets/images/icon_red_arrow_left.png", width: 12.w, height: 10.h),
          20.horizontalSpace,
        ]));
  }

  ///左边选择日期组件
  Widget _leftDateListWidget() {
    return ListWheelScrollView.useDelegate(
        itemExtent: 50.h,
        perspective: 0.005,
        diameterRatio: 2,
        onSelectedItemChanged: (index) {
          setState(() {
            selectedDateIndex = index;
            _dateTimeBuild();
            //示例：2024-08-09 20:50:55.086911
            if (kDebugMode) {
              print(dateTimeModels[selectedDateIndex].date);
            }
          });
        },
        childDelegate: ListWheelChildBuilderDelegate(
            builder: (context, index) {
              DateTimeModel model = dateTimeModels[index];
              return Center(
                  child: AppText(
                      text:
                          '${model.displayDate} ${index == 0 ? '(今天)' : index == 1 ? '(明天)' : ''}',
                      fontSize: 16.sp,
                      textColor: selectedDateIndex == index
                          ? const Color(0xFF414140)
                          : const Color(0xFFd3d3d1),
                      fontWeight:
                          selectedDateIndex == index ? FontWeight.w600 : FontWeight.normal));
            },
            childCount: dateTimeModels.length));
  }

  ///右边选择预约时间组件
  Widget _rightTimeListWidget() {
    return ListWheelScrollView.useDelegate(
        itemExtent: 50.h,
        perspective: 0.005,
        diameterRatio: 2,
        onSelectedItemChanged: (index) {
          setState(() {
            selectedTimeIndex = index;
            _dateTimeBuild();
            //示例：08:30
            if (kDebugMode) {
              print(dateTimeModels[selectedDateIndex].times[selectedTimeIndex]);
            }
          });
        },
        childDelegate: ListWheelChildBuilderDelegate(
            builder: (context, index) {
              return Center(
                  child: AppText(
                      text: dateTimeModels[selectedDateIndex].times[index] ?? "",
                      fontSize: 15.sp,
                      textColor: selectedTimeIndex == index
                          ? const Color(0xFF414140)
                          : const Color(0xFFd3d3d1),
                      fontWeight:
                          selectedTimeIndex == index ? FontWeight.w600 : FontWeight.normal));
            },
            childCount: dateTimeModels[selectedDateIndex].times.length));
  }

  ///将选择的时间格式化后回调出去
  void _dateTimeBuild() {
    if (widget.builder != null) {
      var date = dateTimeModels[selectedDateIndex].date;
      var formatDate = DateUtil.formatDate(date, format: "yyyy-MM-dd");
      var time = dateTimeModels[selectedDateIndex].times[selectedTimeIndex];
      widget.builder?.call(formatDate, time);
    }
  }
}

class DateTimeModel {
  final DateTime date;
  final String displayDate;
  final List<String> times;

  DateTimeModel({required this.date})
      : displayDate =
            '${date.month.toString().padLeft(2, '0')}月${date.day.toString().padLeft(2, '0')}日 ${_weekdayString(date.weekday)}',
        times = List.generate(
            48,
            (index) =>
                '${(index ~/ 2).toString().padLeft(2, '0')}:${(index % 2) * 30 == 0 ? '00' : '30'}');

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

List<DateTimeModel> generateDateTimeModels() {
  DateTime now = DateTime.now();
  return List.generate(5, (index) {
    DateTime date = now.add(Duration(days: index));
    return DateTimeModel(date: date);
  });
}
