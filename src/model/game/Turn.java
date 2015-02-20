package model.game;

import model.player.Player;
import model.word.Word;

import java.io.Serializable;

public class Turn implements Serializable {

    private Word word;
    private Player player;

    public Turn(Word word, Player player) {
        this.word = word;
        this.player = player;
    }

    public Word getWord() {
        return word;
    }

    public Player getPlayer() {
        return player;
    }

}
