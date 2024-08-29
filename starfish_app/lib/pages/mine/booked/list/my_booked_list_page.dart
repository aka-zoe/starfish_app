import 'package:flustars/flustars.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:starfish_api/api/models/my_booked_list_data.dart';
import 'package:starfish_common_ui/common_ui/styles/app_colors.dart';
import 'package:starfish_common_ui/common_ui/title/app_text.dart';

import 'my_booked_list_vm.dart';

///我的预约记录页面
class MyBookedListPage extends StatefulWidget {
  const MyBookedListPage({super.key});

  @override
  State createState() {
    return _MyBookedListPageState();
  }
}

class _MyBookedListPageState extends State<MyBookedListPage> {
  final MyBookedViewModel _viewModel = MyBookedViewModel();

  @override
  void initState() {
    super.initState();
    _viewModel.getBookedList();
  }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider<MyBookedViewModel>(
        create: (context) {
          return _viewModel;
        },
        child: Scaffold(
          backgroundColor: Colors.white,
          appBar: AppBar(
            title: const Text("我的预约"),
          ),
          body: SafeArea(
            child: Consumer<MyBookedViewModel>(
              builder: (context, vm, child) {
                return ListView.builder(
                    itemCount: vm.bookedList?.length ?? 0,
                    itemBuilder: (context, index) {
                      var item = vm.bookedList?[index];
                      return _item(data: item, onItemTap: () {});
                    });
              },
            ),
          ),
        ));
  }

  Widget _item({MyBookedData? data, GestureTapCallback? onItemTap}) {
    return GestureDetector(
        onTap: onItemTap,
        child: Container(
            decoration: BoxDecoration(
                border: Border(bottom: BorderSide(color: AppColors.textColorF6, width: 1.h))),
            padding: EdgeInsets.only(top: 23.h, bottom: 23.h),
            child: Row(mainAxisAlignment: MainAxisAlignment.start, children: [
              17.horizontalSpace,
              //标题
              Column(crossAxisAlignment: CrossAxisAlignment.start, children: [
                AppText(
                    text: data?.houseName ?? "", textColor: AppColors.textColor40, fontSize: 18.sp),
                10.verticalSpace,
                AppText(
                    text:
                        "预约时间：${DateUtil.formatDateMs(data?.bookedtime?.toInt() ?? 0, format: "yyyy-MM-dd HH:mm")}",
                    textColor: AppColors.textColor8B,
                    fontSize: 13.sp)
              ]),
              Expanded(child: SizedBox()),
              AppText(
                  text: _viewModel.getStatus(data?.status),
                  textColor: AppColors.textRedColor39,
                  fontSize: 15.sp),
              17.horizontalSpace
            ])));
  }
}
