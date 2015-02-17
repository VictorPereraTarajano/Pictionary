package model.messagedata.impl;

import model.game.Lobby;
import model.messagedata.interfaces.MessageData;

import java.io.Serializable;

public class HostMigrationData implements MessageData, Serializable {

    private Lobby lobby;

    public HostMigrationData(Lobby lobby) {
        this.lobby = lobby;
    }

    public Lobby getLobby() {
        return lobby;
    }
}
