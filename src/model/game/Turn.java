package model.game;

import model.player.Player;
import model.word.Word;

import java.io.Serializable;

public class Turn implements Serializable {

    private Word word;
    private Player player;
    private Player [] nonPainterPlayers;

    public Turn(Word word, Player player, Player [] nonPainterPlayers) {
        this.word = word;
        this.nonPainterPlayers=nonPainterPlayers;
        this.player = player;
    }

    public Player[] getNonPainterPlayers() {
        return nonPainterPlayers;
    }

    public Word getWord() {
        return word;
    }

    public Player getPlayer() {
        return player;
    }

}
