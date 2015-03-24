package model.word;

import java.io.Serializable;

public class Word implements Serializable {

    private Letter [] word;

    public Word(String words) {
        word = descomponseWord(words);
    }

    public Letter[] getWord() {
        return word;
    }

    private Letter [] descomponseWord (String words) {
        char [] charArray = words.toCharArray();
        word = new Letter[words.length()];
        for (int i = 0; i < charArray.length; i++)
            word[i] = new Letter(charArray[i]);
        return word;
    }

    public String getVisibleWord() {
        String result = "";
        for (Letter letter : word) result+=letter.getLetter();
        return result.toUpperCase();
    }

    public int length () {
        return word.length;
    }

    public String getHiddenWord () {
        String result = "";
        for (Letter letter : word)
            if(letter.isVisible())
                result+=letter.getLetter();
            else
                result+=" _ ";
        return result;
    }

    public void setVisible (int position, boolean visible) {
        word[position].setVisible(visible);
    }

    @Override
    public boolean equals(Object obj) {
        return ((Word) obj).getVisibleWord().equals(getVisibleWord());
    }

    @Override
    public String toString ( ){
        return getVisibleWord();
    }
}
