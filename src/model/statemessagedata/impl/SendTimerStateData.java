package model.statemessagedata.impl;

import model.statemessagedata.interfaces.SendStateData;

public class SendTimerStateData extends SendStateData {

    private int count;

    public SendTimerStateData(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

}
