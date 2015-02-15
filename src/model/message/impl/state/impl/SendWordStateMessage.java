package model.message.impl.state.impl;

import model.message.impl.state.interfaces.SendStateMessage;
import model.messagedata.impl.statedata.impl.SendWordStateData;

public class SendWordStateMessage extends SendStateMessage {

    private SendWordStateData sendWordStateData;

    public SendWordStateMessage(SendWordStateData sendWordStateData) {
        super();
        this.sendWordStateData = sendWordStateData;
    }

    @Override
    public void open() {

    }
}
