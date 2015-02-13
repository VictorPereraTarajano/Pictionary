package model.messagedata.impl;

import model.data.Data;
import model.messagedata.interfaces.MessageData;
import model.player.Player;

import java.io.Serializable;

public class ConfirmationData implements MessageData, Serializable {

    private Player player;

    public ConfirmationData(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public Data[] getData() {
        return new Data[0];
    }
}
