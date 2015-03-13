package controller.impl.sendcommand.statemessage.impl;

import model.manager.ManagerLobby;
import controller.impl.sendcommand.statemessage.interfaces.SendStateMessage;
import controller.impl.sendcommand.statemessagedata.impl.SendTimerStateData;

public class SendTimerStateMessage extends SendStateMessage {

    private SendTimerStateData sendTimerStateData;

    public SendTimerStateMessage(SendTimerStateData sendTimerStateData) {
        this.sendTimerStateData = sendTimerStateData;
    }

    @Override
    public void open() {
        ManagerLobby.myLobby.getTimer().setCount(sendTimerStateData.getCount());
        ManagerLobby.myLobbyFrame.getTimerPanel().refresh(sendTimerStateData.getCount());
    }
}
