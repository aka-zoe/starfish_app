import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:starfish_common_ui/common_ui/styles/app_colors.dart';
import 'package:starfish_common_ui/common_ui/title/app_text.dart';
import 'package:starfish_tenement_app/pages/message/message_vm.dart';

//消息通知页面
class MessagePage extends StatefulWidget {
  const MessagePage({super.key});

  @override
  State createState() {
    return _MessagePageState();
  }
}

class _MessagePageState extends State<MessagePage> {
  final _vm = MessageViewModel();

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
        create: (context) {
          return _vm;
        },
        child: Scaffold(
          backgroundColor: Colors.white,
          appBar: AppBar(title: const Text("消息通知")),
          body: SafeArea(
            child:ListView.builder(
                itemCount: 30,
                itemBuilder: (context, index) {
                  return _messageItem();
                }),
          ),
        ));
  }

  Widget _messageItem() {
    return Container(
        padding: EdgeInsets.only(left: 15.w, top: 10.h, bottom: 8.h, right: 10.w),
        decoration: BoxDecoration(
            border: Border(bottom: BorderSide(color: AppColors.lineColorF8, width: 1.r))),
        child: Row(
            children: [
          ClipRRect(
              borderRadius: BorderRadius.all(Radius.circular(20.r)),
              child: Image.network("https://k.sinaimg.cn/n/sinakd20117/0/w800h800/20240127/889b-4c8a7876ebe98e4d619cdaf43fceea7c.jpg/w700d1q75cms.jpg", width: 40.r, height: 40.r)),
          10.horizontalSpace,
          Expanded(child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      AppText(text: "title", maxLines: 1, fontSize: 15.sp),
                      AppText(text: "2023-09-09 18:09:00", maxLines: 1, fontSize: 13.sp),
                    ]),
                AppText(text: "subTitle", maxLines: 1, fontSize: 13.sp),
              ])),
        ]));
  }
}
