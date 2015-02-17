package model.game;

import model.word.WordSet;
import view.persistence.impl.WordSetLoader;

import java.io.Serializable;

public class Game implements Serializable {

    private static final int MAX_TURNS=10;
    private Turn [] turns;
    private WordSet wordSet;

    public Game() {
        turns=new Turn[MAX_TURNS];
        wordSet = new WordSetLoader().load();
    }

    public WordSet getWordSet() {
        return wordSet;
    }


    public Turn getTurn (int i) {
        return turns[i];
    }
}
