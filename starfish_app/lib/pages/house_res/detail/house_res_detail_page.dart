import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class HouseResDetailPage extends StatefulWidget {
  @override
  State createState() {
    return _HouseResDetailPageState();
  }
}

class _HouseResDetailPageState extends State<HouseResDetailPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: SafeArea(
      child: Column(children: [

      ]),
    ));
  }

  Widget _titleOperationBar(){
  return  Padding(padding: EdgeInsets.only(top: 18.h,left: 21.w,right: 21.w),child: Row(children: [

  ],));
  }
}
