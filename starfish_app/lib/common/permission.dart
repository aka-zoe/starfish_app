import 'package:flutter/cupertino.dart';
import 'package:permission_handler/permission_handler.dart';
import 'package:starfish_common_ui/common_ui/dialog/dialog_factory.dart';
import 'package:starfish_tenement_app/common/location.dart';
import 'package:starfish_utils/utils/permission_utils.dart';

class AppPermission {
  static Future requestNotification(BuildContext context) async {
    var status = await PermissionUtils.requestNotification();
    if (!status) {
      await DialogFactory.instance.showRequestPermissionDialog(
          context: context,
          content: "当前应用需要获取通知权限，是否进入设置打开？",
          confirmClick: () {
            PermissionUtils.openMobileSettings();
          });
    }
  }

  static Future requestLocation(BuildContext context, ValueChanged<bool> callback) async {
    await PermissionUtils.requestLocation((status) async {
      print("_HomePageState requestLocation status=$status");
      if (!status) {
        await DialogFactory.instance.showRequestPermissionDialog(
            context: context,
            content: "当前应用需要获取定位权限，是否进入设置打开？",
            cancelClick: () {
              callback.call(false);
            },
            confirmClick: () {
              PermissionUtils.openMobileSettings();
            });
      } else {
        callback.call(true);
      }
    });
  }

  static Future requestAppPermission(BuildContext context, ValueChanged<bool> callback) async {
    PermissionUtils.requestPermissions([
      Permission.notification,
      Permission.location,
      Permission.locationAlways,
      Permission.locationWhenInUse
    ], (status) {
      if (status) {
        callback.call(true);
      } else {
        DialogFactory.instance.showRequestPermissionDialog(
            context: context,
            content: "当前应用需要获取通知以及定位权限，是否进入设置打开？",
            cancelClick: () {
              callback.call(false);
            },
            confirmClick: () {
              PermissionUtils.openMobileSettings();
            });
      }
    });
  }
}
