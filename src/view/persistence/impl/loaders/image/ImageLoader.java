package view.persistence.impl.loaders.image;

import view.persistence.interfaces.Loader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader implements Loader<BufferedImage> {

    @Override
    public BufferedImage load(String filename) {
        try {
            return ImageIO.read(getClass().getResource(filename));
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot load the file : "+filename);
        }
    }
}
