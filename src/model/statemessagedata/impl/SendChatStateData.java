package model.statemessagedata.impl;

import model.chat.ChatMessage;
import model.statemessagedata.interfaces.SendStateData;

public class SendChatStateData extends SendStateData {

    private ChatMessage chatMessage;

    public SendChatStateData(ChatMessage chatMessage) {
        this.chatMessage = chatMessage;
    }

    public ChatMessage getChatMessage() {
        return chatMessage;
    }
}
