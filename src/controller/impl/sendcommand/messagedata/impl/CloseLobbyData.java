package controller.impl.sendcommand.messagedata.impl;

import controller.impl.sendcommand.messagedata.interfaces.MessageData;
import model.player.Player;

import java.io.Serializable;

public class CloseLobbyData implements MessageData, Serializable {

    private Player player;

    public CloseLobbyData(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

}
