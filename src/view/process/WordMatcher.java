package view.process;

import model.word.Word;

public class WordMatcher {
    public static boolean match (Word word1, Word word2) {
        return word1.equals(word2);
    }
}
