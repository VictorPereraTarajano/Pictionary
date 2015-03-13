package controller.impl.sendcommand.statemessage.impl;

import controller.impl.sendcommand.statemessage.interfaces.SendStateMessage;
import controller.impl.sendcommand.statemessagedata.impl.SendWordStateData;

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
