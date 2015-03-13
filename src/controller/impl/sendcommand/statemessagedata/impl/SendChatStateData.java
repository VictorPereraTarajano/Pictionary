package controller.impl.sendcommand.statemessagedata.impl;

import model.chat.ChatMessage;
import controller.impl.sendcommand.statemessagedata.interfaces.SendStateData;

public class SendChatStateData extends SendStateData {

    private ChatMessage chatMessage;

    public SendChatStateData(ChatMessage chatMessage) {
        this.chatMessage = chatMessage;
    }

    public ChatMessage getChatMessage() {
        return chatMessage;
    }
}
