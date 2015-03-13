package controller.impl.sendcommand.statemessagedata.impl;

import controller.impl.sendcommand.statemessagedata.interfaces.SendStateData;

public class SendTimerStateData extends SendStateData {

    //public SendTimerStateData START = new SendTimerStateData(99);

    private int count;

    public SendTimerStateData (int count) {
        this.count=count;
    }

    public int getCount() {
        return count;
    }
}
