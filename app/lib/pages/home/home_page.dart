import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:starfish_tenement_app/common_ui/app_bar/app_title_bar.dart';

class HomePage extends StatefulWidget{
  const HomePage({super.key});

  @override
  State<StatefulWidget> createState() {
    return _HomePageState();
  }

}

class _HomePageState extends State<HomePage>{
  @override
  Widget build(BuildContext context) {
   return Scaffold(body: SafeArea(
     child: Column(
        children: [AppTitleBar(),],
     ),
   ));
  }

}
