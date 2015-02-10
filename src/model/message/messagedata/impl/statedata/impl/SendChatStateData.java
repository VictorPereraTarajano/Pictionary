package model.message.messagedata.impl.statedata.impl;

import model.data.Data;
import model.message.messagedata.impl.statedata.interfaces.SendStateData;

public class SendChatStateData extends SendStateData {

    private String message;

    public SendChatStateData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public Data[] getData() {
        return new Data[0];
    }
}
