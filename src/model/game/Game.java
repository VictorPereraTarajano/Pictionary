package model.game;

import model.manager.ManagerLobby;
import model.word.WordSet;
import view.persistence.impl.loaders.wordset.FactoryWordLoader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {

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

    public boolean isFinished () {
        return pointer + 1 == turns.size();
    }

    public Turn currentTurn () {
        return ManagerLobby.myPlayer.equals(ManagerLobby.myLobby.getHost()) ? turns.get(pointer) : turns.get(turns.size()-1);
    }

    public Turn nextTurn() {
        return turns.get(++pointer);
    }

}
