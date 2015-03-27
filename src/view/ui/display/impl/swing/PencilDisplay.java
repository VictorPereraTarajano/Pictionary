package view.ui.display.impl.swing;

import model.manager.ManagerLobby;
import view.persistence.impl.loaders.image.FactoryImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class PencilDisplay extends JComponent {

    private static final int maxAngle=90;

    private BufferedImage image;

    public PencilDisplay() {
        init();
    }

    private void init () {
        image = FactoryImageLoader.PENCIL;
        BufferedImage bf = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bf.createGraphics();
        g2.drawImage(image, 0,0, null);
        g2.dispose();
    }

    @Override
    protected void paintComponent(Graphics g1) {
        if (ManagerLobby.myLobby.getCanvas().getPencil().isVisible()) drawPencil(g1);
    }

    private void drawPencil (Graphics g) {
        g.drawImage(rotate(), ManagerLobby.myLobby.getCanvas().getPencil().getPosition().x - 256, ManagerLobby.myLobby.getCanvas().getPencil().getPosition().y - 256, null);
    }

    public Image rotate () {
        return new AffineTransformOp(AffineTransform.getRotateInstance(Math.toRadians(getRotation()), image.getWidth() / 2, image.getHeight() / 2), AffineTransformOp.TYPE_BILINEAR).filter(image, null);
    }

    private double getRotation() {
        return (maxAngle*ManagerLobby.myLobby.getCanvas().getPencil().getPosition().y)/ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().getSize().height;
    }
}
