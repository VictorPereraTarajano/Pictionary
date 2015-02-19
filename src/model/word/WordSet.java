package model.word;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WordSet implements Serializable {

    private List<Word> wordList;

    public WordSet() {
        wordList=new ArrayList<>();
    }

    public void add(Word word) {
        wordList.add(word);
    }

    public Word get(int i){
        return wordList.get(i);
    }

    public int size () {
        return wordList.size();
    }
}
