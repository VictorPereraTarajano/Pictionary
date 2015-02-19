package model.messagedata.impl;

import model.game.Game;
import model.messagedata.interfaces.MessageData;

import java.io.Serializable;

public class StartGameData implements Serializable, MessageData {

    private Game game;

    public StartGameData(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}
