package view.persistence.impl;

import view.persistence.interfaces.Loader;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ClipSoundLoader implements Loader<Clip> {

    private static final String filename = "/sound/sonido.wav";

    @Override
    public Clip load() {
        try {
            Clip sound = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            sound.open(AudioSystem.getAudioInputStream(getClass().getResource(filename)));
            return sound;
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            throw new IllegalArgumentException("Cannot load the file : "+filename);
        }
    }

}
