package controller.impl.sendcommand.statemessage.impl;

import controller.impl.sendcommand.statemessage.interfaces.SendStateMessage;
import controller.impl.sendcommand.statemessagedata.impl.SendPencilStateData;

public class SendPencilStateMessage extends SendStateMessage {

    private SendPencilStateData sendPencilStateData;

    public SendPencilStateMessage(SendPencilStateData sendPencilStateData) {
        this.sendPencilStateData = sendPencilStateData;
    }

    @Override
    public void open() {

    }
}
