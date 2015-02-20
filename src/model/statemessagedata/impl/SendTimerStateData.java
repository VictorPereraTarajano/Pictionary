package model.statemessagedata.impl;

import model.statemessagedata.interfaces.SendStateData;
import model.timer.Timer;

public class SendTimerStateData extends SendStateData {

    private Timer timer;

    public SendTimerStateData(Timer timer) {
        this.timer = timer;
    }

    public Timer getTimer() {
        return timer;
    }
}
