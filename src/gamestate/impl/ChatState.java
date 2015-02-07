package gamestate.impl;

import gamestate.interfaces.State;
import message.Message;
import player.Player;

import java.io.Serializable;

public class ChatState extends State implements Serializable {

    private Player player;
    private Message message;

    public ChatState(Player player, Message message) {
        this.player = player;
        this.message = message;
    }

    public Player getPlayer() {
        return player;
    }

    public Message getMessage() {
        return message;
    }

    @Override
    public void show() {
        System.out.println(player.getName()+": "+message.getMessage());
    }
}
