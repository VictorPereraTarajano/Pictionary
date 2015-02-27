package view.persistence.impl;

import model.word.Word;
import model.word.WordSet;
import view.persistence.interfaces.Loader;

public class WordSetLoader implements Loader<WordSet>{
    @Override
    public WordSet load() {
        WordSet wordSet = new WordSet();
        wordSet.add(new Word("HOLA"));
        wordSet.add(new Word("ADIOS"));
        wordSet.add(new Word("VENGA"));
        wordSet.add(new Word("CASA"));
        return wordSet;
    }
}
