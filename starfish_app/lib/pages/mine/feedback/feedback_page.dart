import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class FeedbackPage extends StatefulWidget{
  const FeedbackPage({super.key});


  @override
  State createState() {
    return _FeedbackPageState();
  }
}

class _FeedbackPageState extends State<FeedbackPage>{

  @override
  Widget build(BuildContext context) {
    return Scaffold(appBar: AppBar(title: Text("反馈"),),);
  }
}
