package model.message.messagedata.impl;

import model.data.Data;
import model.message.messagedata.interfaces.MessageData;

import java.io.Serializable;

public class KickPlayerData implements MessageData, Serializable{
    @Override
    public Data[] getData() {
        return new Data[0];
    }
}
