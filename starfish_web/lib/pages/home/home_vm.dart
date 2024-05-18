import 'package:flutter/cupertino.dart';

class HomeViewModel with ChangeNotifier {
  List<MenuItem> menuList = [];
  int currentIndex = 0;

  void initMenuData() {
    menuList.add(MenuItem("首页Banner", true));
    menuList.add(MenuItem("本期优选", false));
    menuList.add(MenuItem("房源管理", false));
    menuList.add(MenuItem("小区管理", false));
    menuList.add(MenuItem("房源图片", false));
    menuList.add(MenuItem("房源标签", false));
    menuList.add(MenuItem("户型管理", false));
    notifyListeners();
  }


  void setSelectMenu(int index) {
    for (var item in menuList) {
      item.select = false;
    }
    menuList[index].select = true;
    currentIndex = index;
    notifyListeners();
  }
}

class MenuItem {
  String title;
  bool select;

  MenuItem(this.title, this.select);
}
