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

    public PencilDisplay() {
        init();
    }

    private void init () {
        image = new PencilImageLoader().load();
    }

    public BufferedImage getImage() {
        return image;
    }

    public Image rotate () {
        return new AffineTransformOp(AffineTransform.getRotateInstance(Math.toRadians(getRotation()), image.getWidth() / 2, image.getHeight() / 2), AffineTransformOp.TYPE_BILINEAR).filter(image, null);
    }

    private double getRotation() {
        return (maxAngle*ManagerLobby.myLobby.getCanvas().getPencil().getPosition().y)/ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().getSize().height;
    }
}
