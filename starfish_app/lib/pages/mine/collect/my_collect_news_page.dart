import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:starfish_tenement_app/pages/mine/collect/my_collect_vm.dart';
import 'package:starfish_tenement_app/pages/news/news_type/news_type_page.dart';

///资讯收藏
class MyCollectNewsPage extends StatefulWidget {
  const MyCollectNewsPage({super.key});

  @override
  State createState() {
    return _MyCollectNewsPageState();
  }
}

class _MyCollectNewsPageState extends State<MyCollectNewsPage> {
  final MyCollectViewModel _viewModel = MyCollectViewModel();

  @override
  void initState() {
    super.initState();
    _viewModel.getCollectList(2);
  }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider<MyCollectViewModel>(
        create: (context) {
          return _viewModel;
        },
        child: Scaffold(
          appBar: AppBar(
            title: const Text("资讯收藏"),
          ),
          body: SafeArea(
              child: Expanded(
            child: Padding(padding: EdgeInsets.only(left: 17.w,right: 14.w),child: Consumer<MyCollectViewModel>(
              builder: (context, vm, child) {
                return ListView.builder(
                    itemCount: vm.newsList?.length ?? 0,
                    itemBuilder: (context, index) {
                      var item = vm.newsList?[index];
                      return newsItemView(item: item, onCollectTap: () {});
                    });
              },
            )),
          )),
        ));
  }
}
