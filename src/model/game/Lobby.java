package model.game;

import model.canvas.Canvas;
import model.chat.Chat;
import model.player.playerset.impl.ArrayListPlayerSet;
import model.scoring.Scoring;

import java.io.Serializable;

public class Lobby implements Serializable {

    private ArrayListPlayerSet playerSet;
    private Chat chat;
    private Canvas canvas;
    private Scoring scoring;
    private Game game;

    public Lobby() {
        playerSet = new ArrayListPlayerSet();
        chat = new Chat();
        canvas = new Canvas();
        scoring = new Scoring();
        game = new Game();
    }

    public ArrayListPlayerSet getPlayerSet() {
        return playerSet;
    }

    public Game getGame() {
        return game;
    }

    public Chat getChat() {
        return chat;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public Scoring getScoring() {
        return scoring;
    }
}
