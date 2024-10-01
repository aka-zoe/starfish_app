import 'package:flutter/cupertino.dart';
import 'package:permission_handler/permission_handler.dart';

class PermissionUtils {
  PermissionUtils._();

  ///打开系统设置页面
  static Future<bool> openMobileSettings() => openAppSettings();

  ///请求通知权限
  static Future<bool> requestNotification() async {
    PermissionStatus status = await Permission.notification.request();
    return status == PermissionStatus.granted;
  }

  ///请求定位
  static Future requestLocation(ValueChanged<bool> callback) async {
    List<Permission> permissions = [
      Permission.location,
      Permission.locationAlways,
      Permission.locationWhenInUse
    ];
    await requestPermissions(permissions, callback);
  }

  ///请求自定义权限
  static Future requestPermissions(
      List<Permission> permissions, ValueChanged<bool> callback) async {
    Map<Permission, PermissionStatus> statusMap = await permissions.request();
    bool granted = true;
    statusMap.forEach((key, value) {
      //有一个不通过就返回false，要去打开权限
      if (value != PermissionStatus.granted) {
        granted = false;
      }
    });
    callback.call(granted);
  }
}
