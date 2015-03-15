package view.persistence.impl;

import view.persistence.interfaces.Loader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PencilImageLoader implements Loader<BufferedImage> {

    private static final String filepath ="C:\\Users\\Victor\\IdeaProjects\\Pictionary\\out\\production\\Pinturillo\\colours\\redpencil.png";

    @Override
    public BufferedImage load() {
        try {
            return ImageIO.read(new File(filepath));
        } catch (IOException e) {
            return null;
        }
    }
}
