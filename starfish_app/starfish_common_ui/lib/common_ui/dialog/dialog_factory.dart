import 'dart:async';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:starfish_common_ui/common_ui/dialog/parent_dialog.dart';

///通用弹窗工具类
class DialogFactory {
  static DialogFactory instance = DialogFactory();

  ///[touchOutsideDismiss]       是否可以点击空白处消失
  ///[backgroundColor]           弹窗外部区域背景色
  ///[borderRadius]              弹窗圆角
  ///[width]                     宽度
  ///[height]                    高度
  ///[margin]                    外边距
  ///[padding]                   内边距
  ///[outsideOnTap]              弹窗外部区域点击事件
  ///[dismissClick]              底部透明消失按钮事件
  ///[showTransparenceButton]    是否显示底部透明消失按钮
  ///[touchOutsideCloseKeyboard] 是否点击空白区域关闭软键盘
  ///[child]                     弹窗子布局
  Future showParentDialog(
      {required BuildContext context,
      bool? touchOutsideDismiss,
      Color? backgroundColor,
      double? borderRadius,
      double? width,
      double? height,
      EdgeInsetsGeometry? margin,
      EdgeInsetsGeometry? padding,
      GestureTapCallback? outsideOnTap,
      GestureTapCallback? dismissClick,
      bool? showTransparenceButton,
      bool? touchOutsideCloseKeyboard,
      Color? bodyBgColor,
      required Widget child}) {
    return showDialog(
        context: context,
        builder: (context) {
          return ParentDialog(
              bodyBgColor: bodyBgColor,
              touchOutsideDismiss: touchOutsideDismiss,
              touchOutsideCloseKeyboard: touchOutsideCloseKeyboard,
              outsideBackgroundColor: backgroundColor,
              borderRadius: borderRadius,
              width: width,
              height: height,
              margin: margin,
              padding: padding,
              outsideOnTap: outsideOnTap,
              childWidget: child,
              dismissClick: dismissClick,
              showTransparenceButton: showTransparenceButton);
        });
  }

  ///检测新版本弹窗
  Future showNeedUpdateDialog(
      {required BuildContext context,
      GestureTapCallback? dismissClick,
      GestureTapCallback? confirmClick}) async {
    showParentDialog(
        context: context,
        child: TipsCommonDialog(
          title: "检测到新版本，是否下载更新？",
          dialogContentType: DialogContentType.Normal,
          dialogButtonType: DialogButtonType.DoubleButton,
          leftOnTap: () {
            Navigator.pop(context);
            dismissClick?.call();
          },
          rightOnTap: () {
            Navigator.pop(context);
            confirmClick?.call();
          },
        ),
        touchOutsideDismiss: false);
  }

  ///展示请求网络权限弹窗
  Future showRequestPermissionDialog(
      {required BuildContext context,
      String? content,
      GestureTapCallback? cancelClick,
      GestureTapCallback? confirmClick}) async {
    return await showParentDialog(
        context: context,
        child: TipsCommonDialog(
          title: content ?? "是否进入设置打开权限？",
          dialogContentType: DialogContentType.Normal,
          dialogButtonType: DialogButtonType.DoubleButton,
          leftOnTap: () {
            Navigator.pop(context);
            cancelClick?.call();
          },
          rightOnTap: () {
            Navigator.pop(context);
            confirmClick?.call();
          },
        ),
        touchOutsideDismiss: false);
  }
}
