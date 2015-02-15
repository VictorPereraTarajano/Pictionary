package model.messagedata.impl;

import model.messagedata.interfaces.MessageData;
import model.player.Player;

import java.io.Serializable;

public class KickPlayerData implements MessageData, Serializable{
    private Player player;
    private String message;

    public KickPlayerData(Player player, String message) {
        this.player = player;
        this.message = message;
    }

    public Player getPlayer() {
        return player;
    }

    public String getMessage() {
        return message;
    }
}
