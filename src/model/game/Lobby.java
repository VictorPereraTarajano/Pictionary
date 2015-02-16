package model.game;

import model.canvas.Canvas;
import model.chat.Chat;
import model.scoring.Scoring;
import model.timer.Timer;
import model.word.Word;

import java.io.Serializable;

public class Lobby implements Serializable {

    private Chat chat;
    private Canvas canvas;
    private Scoring scoring;
    private Game game;
    private Timer timer;
    private Word word;

    public Lobby() {
        scoring = new Scoring();
        chat = new Chat();
        canvas = new Canvas();
        game = new Game();
        timer=new Timer();
        word =new Word();
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

    public void setScoring (Scoring scoring) {
        this.scoring=scoring;
    }

    public Scoring getScoring() {
        return scoring;
    }

    public Timer getTimer() {
        return timer;
    }
}
