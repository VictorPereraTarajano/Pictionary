package model.message.impl.state.impl;

import model.message.impl.state.interfaces.SendStateMessage;
import model.messagedata.impl.statedata.impl.SendChatStateData;
import model.manager.ManagerLobby;

public class SendChatStateMessage extends SendStateMessage{

    private SendChatStateData sendChatStateData;

    public SendChatStateMessage(SendChatStateData sendChatStateData) {
        super();
        this.sendChatStateData=sendChatStateData;
    }

    @Override
    public void open() {
        ManagerLobby.myLobbyFrame.getChatPanel().getChatDisplay().display(sendChatStateData);
    }
}
