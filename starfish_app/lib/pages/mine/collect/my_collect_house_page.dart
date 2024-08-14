import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:starfish_tenement_app/common_ui/house_list/house_res_list_item.dart';
import 'package:starfish_tenement_app/pages/mine/collect/my_collect_vm.dart';

///房源收藏
class MyCollectHousePage extends StatefulWidget {
  const MyCollectHousePage({super.key});

  @override
  State createState() {
    return _MyCollectHousePageState();
  }
}

class _MyCollectHousePageState extends State<MyCollectHousePage> {
  final MyCollectViewModel _viewModel = MyCollectViewModel();

  @override
  void initState() {
    super.initState();
    _viewModel.getCollectList(1);
  }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider<MyCollectViewModel>(
        create: (context) {
          return _viewModel;
        },
        child: Scaffold(
          backgroundColor: Colors.white,
          appBar: AppBar(
            title: const Text("房源收藏"),
          ),
          body: SafeArea(
              child: Expanded(
            child: Padding(
              padding: EdgeInsets.only(left: 17.w, right: 14.w),
              child: Consumer<MyCollectViewModel>(
                builder: (context, vm, child) {
                  return ListView.builder(
                      itemCount: vm.houseResList?.length ?? 0,
                      itemBuilder: (context, index) {
                        return HouseListItem(
                          data: vm.houseResList?[index],
                          onTap: () {},
                        );
                      });
                },
              ),
            ),
          )),
        ));
  }
}
