package model.game;

import model.canvas.Canvas;
import model.chat.Chat;
import model.playerset.impl.ArrayListPlayerSet;
import model.timer.Timer;
import model.word.Word;

import java.io.Serializable;

public class Lobby implements Serializable {

    private ArrayListPlayerSet playerSet;
    private Chat chat;
    private Canvas canvas;
    private Scoring scoring;
    private Game game;
    private Timer timer;
    private Word word;

    public Lobby() {
        playerSet = new ArrayListPlayerSet();
        chat = new Chat();
        canvas = new Canvas();
        scoring = new Scoring();
        game = new Game();
        timer=new Timer();
        word =new Word();

    }

    public ArrayListPlayerSet getPlayerSet() {
        return playerSet;
    }

    public Word getWord() {
        return word;
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

    public Timer getTimer() {
        return timer;
    }
}
