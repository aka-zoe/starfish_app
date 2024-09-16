import 'package:flutter/widgets.dart';
import 'package:starfish_api/api/api_message.dart';
import 'package:starfish_api/api/models/message_data.dart';

class MessageViewModel with ChangeNotifier {
  List<MessageData>? messageList;

  Future getMessage() async {
    MessageListData data = await ApiMessage.api.getMessages();
    messageList = data.messageList ?? [];
    notifyListeners();
  }
}
