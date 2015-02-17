package model.statemessagedata.impl;

import model.game.Lobby;
import model.statemessagedata.interfaces.SendStateData;

public class SendLobbyStateData extends SendStateData {

    private Lobby lobby;

    public SendLobbyStateData(Lobby lobby) {
        this.lobby = lobby;
    }

    public Lobby getLobby() {
        return lobby;
    }

}
