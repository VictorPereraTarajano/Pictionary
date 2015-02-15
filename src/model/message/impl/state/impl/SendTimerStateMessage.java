package model.message.impl.state.impl;

import model.manager.ManagerLobby;
import model.message.impl.state.interfaces.SendStateMessage;
import model.messagedata.impl.statedata.impl.SendTimerStateData;

public class SendTimerStateMessage extends SendStateMessage {

    private SendTimerStateData sendTimerStateData;

    public SendTimerStateMessage(SendTimerStateData sendTimerStateData) {
        this.sendTimerStateData = sendTimerStateData;
    }

    @Override
    public void open() {
        ManagerLobby.myLobby.getTimer().setCount(sendTimerStateData.getCount());
        ManagerLobby.myLobbyFrame.getTimerPanel().refresh();
    }
}
