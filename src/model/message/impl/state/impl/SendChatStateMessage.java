package model.message.impl.state.impl;

import model.message.impl.state.interfaces.SendStateMessage;
import model.message.messagedata.impl.statedata.impl.SendChatStateData;
import model.message.messagedata.impl.statedata.interfaces.SendStateData;

public class SendChatStateMessage extends SendStateMessage{

    private SendChatStateData sendChatStateData;

    public SendChatStateMessage(SendChatStateData sendChatStateData) {
        super();
        this.sendChatStateData=sendChatStateData;
    }

    @Override
    public void open() {
        LobbyFrame.getChatPanel().getChatDisplay().setChatData(sendChatStateData);
        LobbyFrame.getChatPanel().getChatDisplay().display();
    }
}
