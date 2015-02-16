package model.messagedata.impl;

import model.game.Lobby;
import model.messagedata.interfaces.MessageData;
import model.player.Player;

public class HostMigrationData implements MessageData {

    private Player newHost;
    private Lobby lobby;

    public HostMigrationData(Player newHost, Lobby lobby) {
        this.newHost = newHost;
        this.lobby = lobby;
    }

    public Player getNewHost() {
        return newHost;
    }

    public Lobby getLobby() {
        return lobby;
    }
}
