package model.statemessagedata.impl;

import model.messagedata.interfaces.MessageData;

import java.io.Serializable;

public class SendTurnStateData implements MessageData,Serializable {

    private int turnState;

    public SendTurnStateData(int turnState) {
        this.turnState=turnState;
    }

    public int getTurnState() {
        return turnState;
    }
}
