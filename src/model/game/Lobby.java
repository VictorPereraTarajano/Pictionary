package model.game;

import model.canvas.Canvas;
import model.chat.Chat;
import model.player.PlayerSet;
import model.scoring.Scoring;

import java.io.Serializable;

public class Lobby implements Serializable {

    private PlayerSet playerSet;
    private Chat chat;
    private Canvas canvas;
    private Scoring scoring;
    private Game game;

    public Lobby() {
        playerSet = new PlayerSet();
        chat = new Chat();
        canvas = new Canvas();
        scoring = new Scoring();
        game = new Game();
    }

    public PlayerSet getPlayerSet() {
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
