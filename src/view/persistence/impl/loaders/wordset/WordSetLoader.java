package view.persistence.impl.loaders.wordset;

import model.word.Word;
import model.word.WordSet;
import view.persistence.interfaces.Loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordSetLoader implements Loader<WordSet> {

    @Override
    public WordSet load(String filename) {
        try {
            return fillWordSet(new WordSet(), new BufferedReader(new FileReader(String.valueOf(getClass().getClassLoader().getResource(filename)).substring(5))));
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot load the file : "+filename);
        }
    }

    private WordSet fillWordSet(WordSet wordSet, BufferedReader bf) throws IOException {
        String line;
        while ((line = bf.readLine()) != null)
            for (String word : line.split(","))
                wordSet.add(new Word(word));
        return wordSet;
    }
}
