package model.message.impl.state.interfaces;

import model.message.interfaces.Message;
import model.message.messagedata.impl.statedata.interfaces.SendStateData;

import java.io.Serializable;

public abstract class SendStateMessage implements Message, Serializable {

    private SendStateData sendStateData;

    public SendStateMessage(SendStateData sendStateData) {
        this.sendStateData = sendStateData;
    }

    public SendStateData getSendStateData() {
        return sendStateData;
    }
}
