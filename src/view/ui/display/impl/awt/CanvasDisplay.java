package view.ui.display.impl.awt;

import model.messagedata.impl.statedata.impl.SendCanvasStateData;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CanvasDisplay extends Canvas implements view.ui.display.interfaces.CanvasDisplay {

    private SendCanvasStateData sendCanvasStateData;

    private Graphics2D g2d;
    private BufferedImage image;

    public CanvasDisplay() {
        super();
    }

    @Override
    public void update(Graphics g) {
        if (image == null) {
            image = (BufferedImage) createImage(getSize().width, getSize().height);
            g2d = (Graphics2D) image.getGraphics();
        }
        paint(g2d);
        g.drawImage(image, 0, 0, this);
    }


    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        if (sendCanvasStateData != null) g.fillOval(sendCanvasStateData.getPoint().x,sendCanvasStateData.getPoint().y,10,10);
        g.drawImage(image, 0, 0, null);
    }

    public void clear () {
        g2d.setPaint(Color.white);
        g2d.fillRect(0, 0, getSize().width, getSize().height);
        g2d.setPaint(Color.black);
        repaint();
    }

    @Override
    public void display(SendCanvasStateData sendCanvasStateData) {
        this.sendCanvasStateData=sendCanvasStateData;
        repaint();
    }
}
