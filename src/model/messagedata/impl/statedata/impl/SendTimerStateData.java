package model.messagedata.impl.statedata.impl;

import model.messagedata.impl.statedata.interfaces.SendStateData;

public class SendTimerStateData extends SendStateData {

    private int count;

    public SendTimerStateData(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

}
