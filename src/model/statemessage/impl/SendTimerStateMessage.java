package model.statemessage.impl;

import model.manager.ManagerLobby;
import model.statemessage.interfaces.SendStateMessage;
import model.statemessagedata.impl.SendTimerStateData;

public class SendTimerStateMessage extends SendStateMessage {

    private SendTimerStateData sendTimerStateData;

    public SendTimerStateMessage(SendTimerStateData sendTimerStateData) {
        this.sendTimerStateData = sendTimerStateData;
    }

    @Override
    public void open() {
        ManagerLobby.myLobby.getTimer().setCount(sendTimerStateData.getTimer().getCount());
        ManagerLobby.myLobbyFrame.getTimerPanel().refresh();
    }
}
