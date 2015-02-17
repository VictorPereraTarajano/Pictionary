package model.statemessagedata.impl;

import model.statemessagedata.interfaces.SendStateData;
import model.player.Player;

public class SendChatStateData extends SendStateData {

    private Player player;
    private String message;

    public SendChatStateData(Player player, String message) {
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
