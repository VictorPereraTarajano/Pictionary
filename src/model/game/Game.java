package model.game;

import model.word.WordSet;
import view.persistence.impl.WordSetLoader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {

    private List<Turn> turns;
    private WordSet wordSet;

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

    public Turn getActualTurn () {
        return turns.get(turns.size()-1);
    }
}
