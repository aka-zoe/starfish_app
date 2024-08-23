import 'package:flutter/foundation.dart';
import 'package:umeng_push_sdk/umeng_push_sdk.dart';
import 'package:umeng_common_sdk/umeng_common_sdk.dart';

class PushUtils {
  static Future registerPush() async {
    // UmengPushSdk.setLogEnable(kDebugMode);
    UmengCommonSdk.initCommon(
            "66a64da0192e0574e74d5585", "", "Android", "7331b564a2a0a49cd576addeec74c024")
        .then((value) async {
      String? token = await UmengPushSdk.getRegisteredId();
      print("deviceToken = $token");
    });
    UmengPushSdk.register("", "");
    UmengPushSdk.setTokenCallback((result) {
      print("deviceToken = $result");
    });

    ///{"display_type":"custom","body":{"add_badge":0,"play_sound":"false","play_lights":"false","custom":{"ticker":"测试推送消息内容2","text":"测试推送消息内容","title":"测试推送消息标题"},"badge":0,"play_vibrate":"false","builder_id":0},"msg_id":"uul2rsn172241190457400","agoo_msg_id":"f__-bvhAEcTlvI0D&&uul2rsn172241190457400&&AjVGvmpMkTnTwdMFopxl1k-aBT2gLAuhcPjli2v1EbgK&&11&&"}
    UmengPushSdk.setMessageCallback((result) {
      //隐式消息，不显示在通知栏
      print("setMessageCallback result=$result");
    });

    ///{"display_type":"notification","extra":{},"body":{"add_badge":0,"title":"测试推送消息标题","play_sound":"false","play_lights":"false","text":"测试推送消息内容","after_open":"go_app","ticker":"测试推送消息内容2","badge":0,"play_vibrate":"false","builder_id":0},"msg_id":"uur3zs7172241182324900","agoo_msg_id":"f__-bvhBT3j-M5YD&&uur3zs7172241182324900&&AjVGvmpMkTnTwdMFopxl1k-aBT2gLAuhcPjli2v1EbgK&&11&&"}
    UmengPushSdk.setNotificationCallback((result) {
      //收到通知后回调
      print("setNotificationCallback receive result=$result");
    }, (result) {
      //点击通知栏后回调
      //{"display_type":"notification","extra":{},"body":{"add_badge":0,"title":"测试推送消息标题","play_sound":"false","play_lights":"false","text":"测试推送消息内容","after_open":"go_app","ticker":"测试推送消息内容2","badge":0,"play_vibrate":"false","builder_id":0},"msg_id":"uulml21172241171499300","agoo_msg_id":"f__-bvhC9lj0_Z4D&&uulml21172241171499300&&AjVGvmpMkTnTwdMFopxl1k-aBT2gLAuhcPjli2v1EbgK&&11&&"}
      print("setNotificationCallback open result=$result");
    });
  }
}
