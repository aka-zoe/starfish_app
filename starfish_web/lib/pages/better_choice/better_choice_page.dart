import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:starfish_web/common_ui/form_button.dart';
import 'package:starfish_web/common_ui/title/app_title.dart';
import 'package:starfish_web/pages/better_choice/better_choice_vm.dart';
import 'package:starfish_web/repository/data/better_choice_data.dart';
import 'package:starfish_web/styles/app_colors.dart';

import '../../common_ui/card_page.dart';
import '../../common_ui/input_form.dart';

class BetterChoicePage extends StatefulWidget {
  const BetterChoicePage({super.key});

  @override
  State createState() {
    return _BetterChoicePageState();
  }
}

class _BetterChoicePageState extends State<BetterChoicePage> {
  BetterChoiceViewModel viewModel = BetterChoiceViewModel();

  @override
  void initState() {
    super.initState();
    viewModel.getBetterChoiceList();
  }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
        create: (context) {
          return viewModel;
        },
        child: CardPage(
            child: Row(
          children: [
            Expanded(flex: 5, child: _bannerList()),
            Expanded(
                flex: 5,
                child: Consumer<BetterChoiceViewModel>(
                  builder: (context, vm, child) {
                    return Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        crossAxisAlignment: CrossAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [
                          InputForm(text: "标题：", inputController: vm.inputTitle),
                          20.verticalSpace,
                          InputForm(text: "副标题：", inputController: vm.inputSubTitle),
                          20.verticalSpace,
                          InputForm(text: "图片链接：", inputController: vm.inputImgUrl),
                          20.verticalSpace,
                          InputForm(text: "活动链接：", inputController: vm.inputLink),
                          40.verticalSpace,
                          Row(
                            children: [
                              FormButton(text: '清空', bgColor: AppColors.buttonBg, click: () {
                                vm.clearCurrItem();
                              }),
                              10.horizontalSpace,
                              FormButton(text: '确定添加', click: () {
                                if(vm.currentItem?.id==null){
                                  vm.addBetterChoice();
                                }else{
                                  vm.updateBetterChoice();
                                }

                              }),
                            ],
                          ),
                        ]);
                  },
                ))
          ],
        )));
  }

  Widget _bannerList() {
    return Consumer<BetterChoiceViewModel>(builder: (context, vm, child) {
      return ListView.builder(
          itemCount: vm.choiceList?.length ?? 0,
          itemBuilder: (context, index) {
            return _bannerInfoItem(vm.choiceList?[index]);
          });
    });
  }

  Widget _bannerInfoItem(BetterChoiceData? item) {
    return Container(
      padding: EdgeInsets.only(top: 20.h, bottom: 20.h),
      margin: EdgeInsets.only(left: 15.w, right: 45.w),
      decoration:
          BoxDecoration(border: Border(bottom: BorderSide(width: 1.r, color: AppColors.lineColor))),
      child: Row(
        children: [
          Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
            AppText(
              text: "${item?.title}",
              fontSize: 9.sp,
            ),
            AppText(
              text: "${item?.subtitle}",
              fontSize: 7.sp,
            ),
          ],),
          Expanded(child: SizedBox()),
          Text("状态：${viewModel.getStatus(item?.status)}"),
          10.horizontalSpace,
          itemClickText(
              text: "删除",
              textColor: Colors.red,
              onTap: () {
                viewModel.delBanner("${item?.id}");
              }),
          10.horizontalSpace,
          itemClickText(text: "编辑", onTap: () {
            viewModel.setCurrItem(item);
          }),
        ],
      ),
    );
  }

  Widget itemClickText({String? text, GestureTapCallback? onTap, Color? textColor}) {
    return GestureDetector(
      onTap: onTap,
      child: Text(
        text ?? "",
        style: TextStyle(color: textColor ?? Colors.blue, decoration: TextDecoration.underline),
      ),
    );
  }
}
