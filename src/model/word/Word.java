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
        return ((Word) obj).word.toUpperCase().equals(word);
    }
}
