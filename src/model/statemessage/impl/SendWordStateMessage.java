package model.statemessage.impl;

import model.statemessage.interfaces.SendStateMessage;
import model.statemessagedata.impl.SendWordStateData;

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
