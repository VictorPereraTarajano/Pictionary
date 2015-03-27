package view.ui.display.impl.swing;

import model.manager.ManagerLobby;
import view.persistence.impl.loaders.image.FactoryImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class PencilDisplay extends JComponent {

    private static final int maxAngle=90;

    private BufferedImage image;

    public PencilDisplay() {
        init();
    }

    private void init () {
        image = FactoryImageLoader.PENCIL;
    }

    @Override
    protected void paintComponent(Graphics g1) {
        Graphics2D g2 = (Graphics2D) g1;
        super.paintComponent(g2);
        if (ManagerLobby.myLobby.getCanvas().getPencil().isVisible())
            drawPencil(g2);
        else {
            int i = 0;

        }
        setTransparency(0.4f);
    }

    private void setTransparency(float v) {
        byte [] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        for (int i =0; i < pixels.length; i+=4) {
            if (pixels[i] != 0x0) pixels [i]= 0x8;
        }
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
