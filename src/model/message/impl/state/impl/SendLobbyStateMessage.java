package model.message.impl.state.impl;

import model.message.impl.state.interfaces.SendStateMessage;
import model.messagedata.impl.statedata.impl.SendLobbyStateData;

public class SendLobbyStateMessage extends SendStateMessage{

    private SendLobbyStateData sendLobbyStateData;

    public SendLobbyStateMessage(SendLobbyStateData sendLobbyStateData) {
        super();
        this.sendLobbyStateData = sendLobbyStateData;
    }

    @Override
    public void open() {

    }
}
