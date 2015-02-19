package model.word;

import java.io.Serializable;

public class Word implements Serializable {

    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean equals(Object obj) {
        Word word1 =  (Word) obj;
        return word1.word.toUpperCase().equals(word);
    }
}
