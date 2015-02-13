package model.messagedata.impl.statedata.impl;

import model.data.Data;
import model.game.Lobby;
import model.messagedata.impl.statedata.interfaces.SendStateData;

public class SendLobbyStateData extends SendStateData {

    private Lobby lobby;

    public SendLobbyStateData(Lobby lobby) {
        this.lobby = lobby;
    }

    public Lobby getLobby() {
        return lobby;
    }

    @Override
    public Data[] getData() {
        return new Data[0];
    }
}
