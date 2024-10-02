import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:tencent_cloud_chat_uikit/business_logic/model/profile_model.dart';
import 'package:tencent_cloud_chat_uikit/tencent_cloud_chat_uikit.dart';

///IM会话页面
class ChatPage extends StatefulWidget {
  final V2TimConversation selectedConversation;

  const ChatPage({super.key, required this.selectedConversation});

  @override
  State createState() {
    return _ChatPageState();
  }
}

class _ChatPageState extends State<ChatPage> {
  String? _getConvID() {
    return widget.selectedConversation.type == 1
        ? widget.selectedConversation.userID
        : widget.selectedConversation.groupID;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
          child: TIMUIKitChat(
              conversation: widget.selectedConversation,
              onTapAvatar: (userid, tapDetails) {

              })),
    );
  }
}
