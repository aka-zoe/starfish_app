import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:starfish_common_ui/common_ui/navigation/navigation_bar_widget.dart';
import 'package:starfish_tenement_app/pages/home/home_page.dart';
import 'package:starfish_tenement_app/pages/house_res/house_resource_page.dart';
import 'package:starfish_tenement_app/pages/mine/mine_page.dart';
import 'package:starfish_tenement_app/pages/news/news_list_page.dart';


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
    "assets/images/icon_home_un.png",
    "assets/images/icon_search_house_un.png",
    "assets/images/icon_news_un.png",
    "assets/images/icon_mine_un.png"
  ];
  final List<String> tabActiveIcons = [
    "assets/images/icon_home.png",
    "assets/images/icon_search_house.png",
    "assets/images/icon_news.png",
    "assets/images/icon_mine.png"
  ];

  ///State生命周期，在组件渲染前回调
  @override
  void initState() {
    super.initState();
    // WebSocketInstance.instance.connectSocket();
    initTabPage();
  }

  @override
  void dispose() {
    // WebSocketInstance.instance.close();
    super.dispose();
  }

  void initTabPage() {
    tabItems.add(HomePage());
    tabItems.add(HouseResourcePage());
    tabItems.add(NewsListPage());
    tabItems.add(MinePage());
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
