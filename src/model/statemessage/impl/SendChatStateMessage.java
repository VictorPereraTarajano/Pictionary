package model.statemessage.impl;

import model.chat.ChatMessage;
import model.statemessage.interfaces.SendStateMessage;
import model.statemessagedata.impl.SendChatStateData;
import model.manager.ManagerLobby;

public class SendChatStateMessage extends SendStateMessage{

    private SendChatStateData sendChatStateData;

    public SendChatStateMessage(SendChatStateData sendChatStateData) {
        super();
        this.sendChatStateData=sendChatStateData;
    }

    @Override
    public void open() {
        ManagerLobby.myLobby.getChat().add(new ChatMessage(sendChatStateData.getChatMessage().getPlayer(),sendChatStateData.getChatMessage().getMessage()));
        ManagerLobby.myLobbyFrame.getChatPanel().refresh();
    }
}
