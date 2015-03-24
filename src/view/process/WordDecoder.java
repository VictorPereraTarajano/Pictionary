package view.process;

import model.word.Word;

import java.util.Random;

public class WordDecoder {
    public static int decode (Word word) {
        Random r = new Random(System.currentTimeMillis());
        int position;
        do {
            position = r.nextInt(word.length() - 1);
        } while(word.getWord()[position].isVisible());
        return position;
    }
}
