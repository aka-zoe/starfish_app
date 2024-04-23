import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:starfish_tenement_app/pages/home/home_page.dart';

import '../common_ui/navigation/navigation_bar_widget.dart';

class TabPage extends StatefulWidget {
  const TabPage({super.key});

  @override
  State<StatefulWidget> createState() {
    return _TabPageState();
  }
}

class _TabPageState extends State<TabPage> {
  //tab界面集合
  final List<Widget> tabItems = [];
  final List<String> tabLabels = ["首页", "房源", "资讯", "我的"];
  final List<String> tabIcons = [
    "assets/images/icon_home_grey.png",
    "assets/images/icon_hot_key_grey.png",
    "assets/images/icon_knowledge_grey.png",
    "assets/images/icon_personal_grey.png"
  ];
  final List<String> tabActiveIcons = [
    "assets/images/icon_home_selected.png",
    "assets/images/icon_hot_key_selected.png",
    "assets/images/icon_knowledge_selected.png",
    "assets/images/icon_personal_selected.png"
  ];

  ///State生命周期，在组件渲染前回调
  @override
  void initState() {
    super.initState();
    initTabPage();
  }

  void initTabPage() {
    tabItems.add(HomePage());
    tabItems.add(const Text("房源"));
    tabItems.add(const Text("资讯"));
    tabItems.add(const Text("我的"));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: null,
      body: NavigationBarWidget(
        tabItems: tabItems,
        tabLabels: tabLabels,
        tabIcons: tabIcons,
        tabActiveIcons: tabActiveIcons,
      ),
    );
  }
}
