package view.persistence.impl.loaders.clip;

import javax.sound.sampled.Clip;

public class FactoryClipLoader {
    public static Clip START_TURN = new ClipLoader().load("/sound/sonido.wav");
}

