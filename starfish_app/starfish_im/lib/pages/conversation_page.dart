import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:starfish_im/pages/chat_page.dart';
import 'package:tencent_cloud_chat_uikit/tencent_cloud_chat_uikit.dart';

///IM会话页面
class ConversationPage extends StatefulWidget {
  const ConversationPage({super.key});

  @override
  State createState() {
    return _ConversationPageState();
  }
}

class _ConversationPageState extends State<ConversationPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: TIMUIKitConversation(
          onTapItem: (item) {
            Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => ChatPage(
                    selectedConversation: item,
                  ),
                ));
          },
        ),
      ),
    );
  }
}
