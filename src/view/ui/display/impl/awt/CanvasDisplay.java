package view.ui.display.impl.awt;

import model.messagedata.impl.statedata.impl.SendCanvasStateData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CanvasDisplay extends Canvas implements view.ui.display.interfaces.CanvasDisplay {

    private SendCanvasStateData sendCanvasStateData;

    private Graphics2D g2d;
    public BufferedImage image = null;

    public CanvasDisplay() {
        super();
    }

    @Override
    public void update(Graphics g) {
       /*if (image == null) {
            image = (BufferedImage) createImage(getSize().width, getSize().height);
            g2d = (Graphics2D) image.getGraphics();
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0,0,getSize().width,getSize().height);
        }
        paint(g2d);
        g.drawImage(image, 0, 0, this);*/
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        //g.setColor(Color.black);
        //if (sendCanvasStateData != null) applyChanges(g);

        if (image == null) {
            image = (BufferedImage) createImage(getSize().width, getSize().height);
            g2d = (Graphics2D) image.getGraphics();
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0,0,getSize().width,getSize().height);
        }
        if (sendCanvasStateData != null) {
            applyChanges(g2d);
        }
        g.drawImage(image, 0, 0, this);
    }

    private void applyChanges(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(sendCanvasStateData.getPoint().x,sendCanvasStateData.getPoint().y,10,10);
    }

    @Override
    public void display(SendCanvasStateData sendCanvasStateData) {
        this.sendCanvasStateData=sendCanvasStateData;
        repaint();
    }
}
