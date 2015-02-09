package model.message.messagedata.impl;

import model.data.Data;
import model.message.messagedata.interfaces.MessageData;
import model.game.Lobby;
import model.player.Player;

import java.io.Serializable;

public class InvitePlayerData implements MessageData, Serializable {

    private Player player;
    private Lobby lobby;

    public InvitePlayerData(Player player, Lobby lobby) {
        this.player = player;
        this.lobby = lobby;
    }

    @Override
    public Data[] getData() {
        return new Data[0];
    }

    public Player getPlayer() {
        return player;
    }

    public Lobby getLobby() {
        return lobby;
    }

}
