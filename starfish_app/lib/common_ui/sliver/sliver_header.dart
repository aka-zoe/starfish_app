import 'package:flutter/cupertino.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/common_ui/sliver/sliver_app_bar_delegate.dart';

///吸顶布局
class SliverHeader extends StatefulWidget {
  final List<Widget> children;
  final bool? pinned;
  final bool? floating;

  const SliverHeader({super.key, this.pinned, this.floating, required this.children});

  @override
  State createState() {
    return _SliverHeaderState();
  }
}

class _SliverHeaderState extends State<SliverHeader> {
  double? _childHeight;

  @override
  Widget build(BuildContext context) {
    return SliverPersistentHeader(
        pinned: widget.pinned ?? true,
        floating: widget.floating ?? true,
        delegate: SliverAppBarDelegate(
            minHeight: _childHeight ?? 130.h,
            maxHeight: _childHeight ?? 130.h,
            child: LayoutBuilder(
              builder: (context, constraints) {
                //通过LayoutBuilder动态获取子组件的高度
                WidgetsBinding.instance.addPostFrameCallback((timeStamp) {
                  //防止多次回调setState
                  var height = context.size?.height;
                  if (_childHeight == height) {
                    return;
                  }
                  _childHeight = height;
                  if (kDebugMode) {
                    print("_SliverHeaderState _childHeight=$_childHeight");
                  }
                  setState(() {});
                });

                return Container(
                    width: double.infinity,
                    color: Colors.white,
                    child: Column(children: widget.children));
              },
            )));
  }
}
