package view.persistence.impl.loaders.wordset;

import model.word.WordSet;

public class FactoryWordLoader {
    public static WordSet DEFAULT_WORDSET = new WordSetLoader().load("wordset.csv");
}
