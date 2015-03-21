package model.game;

import model.word.WordSet;
import view.persistence.impl.loaders.wordset.FactoryWordLoader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {

    public static final int MAX_TURNS=10;
    private List<Turn> turns;
    private WordSet wordSet;
    private int pointer=0;

    public Game() {
        turns=new ArrayList<>();
        wordSet = FactoryWordLoader.DEFAULT_WORDSET;
    }

    public int getPointer() {
        return pointer;
    }

    public WordSet getWordSet() {
        return wordSet;
    }

    public void addTurn (Turn turn) {
        turns.add(turn);
    }

    public Turn currentTurn () {
        return turns.get(pointer);
    }

    public Turn nextTurn() {
        return turns.get(++pointer);
    }

}
