import 'package:flutter/cupertino.dart';
import 'package:starfish_im/im_config_info.dart';
import 'package:tencent_calls_uikit/tuicall_kit.dart';
import 'package:tencent_cloud_chat_uikit/data_services/conversation/conversation_services.dart';
import 'package:tencent_cloud_chat_uikit/data_services/core/core_services_implements.dart';
import 'package:tencent_cloud_chat_uikit/data_services/core/tim_uikit_config.dart';
import 'package:tencent_cloud_chat_uikit/data_services/services_locatar.dart';
import 'package:tencent_cloud_chat_uikit/tencent_cloud_chat_uikit.dart';
import 'package:tencent_cloud_chat_vote_plugin/tencent_cloud_chat_vote_plugin.dart';

class IMCore {
  final CoreServicesImpl _coreInstance = TIMUIKitCore.getInstance();
  final V2TIMManager _sdkInstance = TIMUIKitCore.getSDKInstance();
  final ConversationService _conversationService = serviceLocator<ConversationService>();
  final CoreServicesImpl coreInstance = TIMUIKitCore.getInstance();


  Future initIM() async {
    _coreInstance.init(
      sdkAppID: IMConfigInfo.sdkappid,
      loglevel: LogLevelEnum.V2TIM_LOG_INFO,
      config: const TIMUIKitConfig(
        isShowOnlineStatus: true,
        isCheckDiskStorageSpace: true,
      ),
      onTUIKitCallbackListener: (TIMCallback callbackValue) {
        switch (callbackValue.type) {
          case TIMCallbackType.INFO:
            debugPrint(callbackValue.infoRecommendText!);
            // Shows the recommend text for info callback directly
            break;
          case TIMCallbackType.API_ERROR:
            //Prints the API error to console, and shows the error message.
            print("Error from TUIKit: ${callbackValue.errorMsg}, Code: ${callbackValue.errorCode}");
            if (callbackValue.errorCode == 10004 &&
                callbackValue.errorMsg!.contains("not support @all")) {
              debugPrint(TIM_t("当前群组不支持@全体成员"));
            } else if (callbackValue.errorCode == -4) {
              return;
            } else if (callbackValue.errorCode == -1) {
              return;
            } else {
              debugPrint(callbackValue.errorMsg ?? callbackValue.errorCode.toString());
            }
            break;

          case TIMCallbackType.FLUTTER_ERROR:
          default:
            // prints the stack trace to console or shows the catch error
            if (callbackValue.catchError != null) {
              debugPrint(callbackValue.catchError.toString());
            } else {
              print(callbackValue.stackTrace);
            }
        }
      },
      listener: V2TimSDKListener(
        onConnectFailed: (code, error) {
          // localSetting.connectStatus = ConnectStatus.failed;
        },
        onConnectSuccess: () {
          // localSetting.connectStatus = ConnectStatus.success;
          debugPrint(TIM_t("即时通信服务连接成功"));
        },
        onConnecting: () {
          // localSetting.connectStatus = ConnectStatus.connecting;
        },
        onKickedOffline: () {},
        onSelfInfoUpdated: (info) {
          // Provider.of<LoginUserInfo>(context, listen: false).setLoginUserInfo(info);
          // onSelfInfoUpdated(info);
        },
        onUserSigExpired: () {
          // userSig过期，相当于踢下线
        },
      ),
    );
  }

  Future userLogin() async {


    String key = IMConfigInfo.key;
    int sdkAppId = IMConfigInfo.sdkappid;


    String userSig = "";

    await TUICallKit.instance.login(sdkAppId, "userID", userSig);

    var data = await coreInstance.login(
      userID: "userID",
      userSig: userSig,
    );
    if (data.code != 0) {
      final option1 = data.desc;
      debugPrint(TIM_t_para("登录失败{{option1}}", "登录失败$option1")(option1: option1));
      return;
    }

    // Initialize the poll plug-in
    TencentCloudChatVotePlugin.initPlugin();

  }
}
