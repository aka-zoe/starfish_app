import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:starfish_tenement_app/common_ui/house_list/house_res_list_item.dart';

import '../../styles/app_colors.dart';
import '../tag/tag_widget.dart';
import '../title/app_title.dart';

class HouseResListWidget extends StatefulWidget {
  const HouseResListWidget({super.key, this.shrinkWrap, this.physics});

  final bool? shrinkWrap;
  final ScrollPhysics? physics;

  @override
  State<StatefulWidget> createState() {
    return _HouseResListWidgetState();
  }
}

class _HouseResListWidgetState extends State<HouseResListWidget> {
  @override
  Widget build(BuildContext context) {
    return _houseListView();
  }

  ///房源列表
  Widget _houseListView() {
    return ListView.builder(
      shrinkWrap: widget.shrinkWrap ?? false,
      physics: widget.physics,
      itemBuilder: (context, index) {
        return HouseListItem();
      },
      itemCount: 10,
    );
  }

}
