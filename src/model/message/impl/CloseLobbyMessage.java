package model.message.impl;

import model.manager.ManagerLobby;
import model.message.interfaces.Message;
import model.messagedata.impl.CloseLobbyData;

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
