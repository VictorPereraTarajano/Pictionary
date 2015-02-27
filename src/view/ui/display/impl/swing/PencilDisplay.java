package view.ui.display.impl.swing;

import model.manager.ManagerLobby;
import view.persistence.impl.PencilImageLoader;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class PencilDisplay {

    private static final int maxAngle=90;

    private BufferedImage image;
    private boolean visible=false;

    private Point point = new Point(0,0);

    public PencilDisplay() {
        init();
    }

    private void init () {
        image = new PencilImageLoader().load();
    }

    public boolean isVisible() {
        return visible;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Point getPoint () {
        return point;
    }

    public void setPosition(Point point) {
        this.point=point;
    }

    public void setVisible(boolean visible) {
        this.visible=visible;
    }

    public Image rotate () {
        return new AffineTransformOp(AffineTransform.getRotateInstance(Math.toRadians(getRotation()), image.getWidth() / 2, image.getHeight() / 2), AffineTransformOp.TYPE_BILINEAR).filter(image, null);
    }

    private double getRotation() {
        return (maxAngle*point.y)/ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().getSize().height;
    }
}
