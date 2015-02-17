package model.game;

import model.player.Player;
import model.word.Word;

import java.io.Serializable;

public class Turn implements Serializable {

    public static final int RUNNING=1;
    public static final int STOPPED=0;

    private Word word;
    private Player player;
    private static int STATUS;

    public Turn(Word word, Player player) {
        STATUS=STOPPED;
        this.word = word;
        this.player = player;
    }

    public Word getWord() {
        return word;
    }

    public Player getPlayer() {
        return player;
    }

    public int getStatus () {
        return STATUS;
    }

    public void setStatus (int status) {
        STATUS=status;
    }

}
