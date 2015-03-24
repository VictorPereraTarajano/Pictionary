package model.word;

import java.io.Serializable;

public class Letter implements Serializable{

    private char letter;
    private boolean isVisible=false;

    public Letter(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
}
