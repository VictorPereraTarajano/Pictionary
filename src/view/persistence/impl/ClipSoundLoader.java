package view.persistence.impl;

import view.persistence.interfaces.Loader;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ClipSoundLoader implements Loader<Clip> {

    private static final String filepath = "C:\\Users\\Victor\\IdeaProjects\\Pictionary\\res\\sound\\sonido.wav";

    @Override
    public Clip load() {
        Clip sound = null;
        try {
            sound = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            sound.open(AudioSystem.getAudioInputStream(new File(filepath)));
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        return sound;
    }

}
