package model.game;

import model.canvas.Canvas;
import model.chat.Chat;
import model.manager.ManagerLobby;
import model.player.Player;
import model.scoring.Scoring;
import model.timer.Timer;

import java.io.Serializable;

public class Lobby implements Serializable {

    private Player host;
    private Chat chat;
    private Canvas canvas;
    private Scoring scoring;
    private Game game;
    private Timer timer;

    public Lobby() {
        host = ManagerLobby.myPlayer;
        scoring = new Scoring();
        chat = new Chat();
        canvas = new Canvas();
        timer=new Timer();
    }

    public Player getHost() {
        return host;
    }

    public void setGame(Game game) {
        this.game=game;
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

    public void setHost(Player host) {
        this.host = host;
    }
}
