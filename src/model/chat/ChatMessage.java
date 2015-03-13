package model.chat;

import model.player.Player;

import java.io.Serializable;

public class ChatMessage implements Serializable{

    private Player player;
    private String message;

    public ChatMessage(Player player, String message) {
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
