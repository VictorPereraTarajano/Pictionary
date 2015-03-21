package view.persistence.impl.loaders.image;

import java.awt.image.BufferedImage;

public class FactoryImageLoader {
    public static BufferedImage PENCIL = new ImageLoader().load("/pencil.png");
    public static BufferedImage REPORT_PLAYER = new ImageLoader().load("/exclamation.png");
    public static BufferedImage CANCEL_CANVAS_DIALOG = new ImageLoader().load("/exitButton.png");
    public static BufferedImage REPORT_PLAYER_2 = new ImageLoader().load("/exclamation2.png");
}
