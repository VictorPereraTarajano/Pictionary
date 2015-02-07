package gamestate.impl.chat;

import gamestate.interfaces.State;

import java.io.Serializable;

public class ChatState extends State implements Serializable {



    @Override
    public void show() {
        System.out.println("Chat State");
    }
}
