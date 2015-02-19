package model.game;

import model.word.WordSet;
import view.persistence.impl.WordSetLoader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {

    public static final int MAX_TURNS=10;
    private List<Turn> turns;
    private WordSet wordSet;
    private int iterator=0;

    public Game() {
        turns=new ArrayList<>();
        wordSet = new WordSetLoader().load();
    }

    public WordSet getWordSet() {
        return wordSet;
    }

    public void addTurn (Turn turn) {
        turns.add(turn);
    }

    public void finishTurn () {
        iterator++;
    }

    public Turn getActualTurn () {
        return turns.get(iterator);
    }
}
