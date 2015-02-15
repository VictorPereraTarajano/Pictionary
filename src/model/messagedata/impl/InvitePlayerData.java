package model.messagedata.impl;

import model.game.Lobby;
import model.messagedata.interfaces.MessageData;
import model.player.Player;

import java.io.Serializable;

public class InvitePlayerData implements MessageData, Serializable {

    private Player player;
    private Lobby lobby;

    public InvitePlayerData(Player player, Lobby lobby) {
        this.player = player;
        this.lobby = lobby;
    }

    public Player getPlayer() {
        return player;
    }

    public Lobby getLobby() {
        return lobby;
    }

}
