package controller.impl.sendcommand.message.impl;

import model.manager.ManagerLobby;
import controller.impl.sendcommand.message.interfaces.Message;
import controller.impl.sendcommand.messagedata.impl.CloseLobbyData;

import java.io.Serializable;

public class CloseLobbyMessage implements Message, Serializable {

    private CloseLobbyData sendCloseLobbyData;

    public CloseLobbyMessage(CloseLobbyData sendCloseLobbyData) {
        this.sendCloseLobbyData = sendCloseLobbyData;
    }

    @Override
    public void open() {
        ManagerLobby.myLobby.getScoring().remove(sendCloseLobbyData.getPlayer());
        ManagerLobby.myLobbyFrame.getScoringPanel().refresh();
    }
}
