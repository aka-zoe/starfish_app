import 'package:flutter/cupertino.dart';

class HomeViewModel with ChangeNotifier {
  List<MenuItem> menuList = [];
  int currentIndex = 0;

  void initMenuData() {
    menuList.add(MenuItem("添加Banner", true));
    menuList.add(MenuItem("添加推荐", false));
    menuList.add(MenuItem("添加房源", false));
    menuList.add(MenuItem("添加小区", false));
    menuList.add(MenuItem("添加房源图片", false));
    menuList.add(MenuItem("添加房源标签", false));
    menuList.add(MenuItem("添加户型", false));
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
