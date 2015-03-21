package view.persistence.impl.loaders.clip;

import view.persistence.interfaces.Loader;

import javax.sound.sampled.*;
import java.io.IOException;

public class ClipLoader implements Loader<Clip> {
    @Override
    public Clip load(String filename) {
        try {
            Clip sound = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            sound.open(AudioSystem.getAudioInputStream(getClass().getResource(filename)));
            return sound;
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            throw new IllegalArgumentException("Cannot load the file : "+filename);
        }
    }
}
