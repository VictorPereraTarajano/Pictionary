package model.messagedata.impl;

import model.game.Turn;
import model.messagedata.interfaces.MessageData;

import java.io.Serializable;

public class StartGameData implements Serializable, MessageData {

    private Turn turn;

    public StartGameData(Turn turn) {
        this.turn = turn;
    }

    public Turn getTurn() {
        return turn;
    }
}
