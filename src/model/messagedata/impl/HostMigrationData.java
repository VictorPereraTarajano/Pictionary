package model.messagedata.impl;

import model.game.Lobby;
import model.messagedata.interfaces.MessageData;
import model.player.Player;

import java.io.Serializable;

public class HostMigrationData implements MessageData, Serializable {

    private Player anotherHost;
    private Lobby lobby;

    public Player getAnotherHost() {
        return anotherHost;
    }

    public HostMigrationData(Player anotherHost, Lobby lobby) {
        this.anotherHost = anotherHost;
        this.lobby = lobby;
    }

    public Lobby getLobby() {
        return lobby;
    }
}
