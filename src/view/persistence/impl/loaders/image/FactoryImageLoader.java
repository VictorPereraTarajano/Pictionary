package view.persistence.impl.loaders.image;

import java.awt.image.BufferedImage;

public class FactoryImageLoader {
    public static BufferedImage PENCIL = new ImageLoader().load("/canvas/pencil.png");
    public static BufferedImage REPORT_PLAYER = new ImageLoader().load("/canvas/exclamation.png");
    public static BufferedImage CANCEL_CANVAS_DIALOG = new ImageLoader().load("/canvas/exitButton.png");
    public static BufferedImage REPORT_PLAYER_2 = new ImageLoader().load("/canvas/exclamation2.png");
    public static BufferedImage ON_BUTTON = new ImageLoader().load("/menu/on.png");
    public static BufferedImage OFF_BUTTON = new ImageLoader().load("/menu/off.png");
    public static BufferedImage TITLE = new ImageLoader().load("/menu/title.png");
    public static BufferedImage ICON_FRAME = new ImageLoader().load("/frame/pinturillo.png");
}
