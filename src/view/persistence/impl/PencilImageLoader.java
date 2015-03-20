package view.persistence.impl;

import view.persistence.interfaces.Loader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PencilImageLoader implements Loader<BufferedImage> {

    private static final String filename ="/pencil.png";

    @Override
    public BufferedImage load() {
        try {
            return ImageIO.read(getClass().getResource(filename));
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot load the file : "+filename);
        }
    }
}
