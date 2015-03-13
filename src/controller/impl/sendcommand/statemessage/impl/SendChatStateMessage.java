package controller.impl.sendcommand.statemessage.impl;

import model.chat.ChatMessage;
import model.manager.ManagerLobby;
import controller.impl.sendcommand.statemessage.interfaces.SendStateMessage;
import controller.impl.sendcommand.statemessagedata.impl.SendChatStateData;

public class SendChatStateMessage extends SendStateMessage {

    private SendChatStateData sendChatStateData;

    public SendChatStateMessage(SendChatStateData sendChatStateData) {
        super();
        this.sendChatStateData=sendChatStateData;
    }

    @Override
    public void open() {
        ManagerLobby.myLobby.getChat().add(new ChatMessage(sendChatStateData.getChatMessage().getPlayer(),sendChatStateData.getChatMessage().getMessage()));
        ManagerLobby.myLobbyFrame.getChatPanel().refresh(sendChatStateData.getChatMessage());
    }
}
