package view.ui.display.impl.swing;

import model.messagedata.impl.statedata.impl.SendCanvasStateData;

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
        Dimension d = getSize();
        Image offscreen = createImage(size().width, size().height);
        Graphics offgc = offscreen.getGraphics();
        offgc.setColor(getBackground());
        offgc.fillRect(0, 0, d.width, d.height);
        offgc.setColor(getForeground());
        paint(offgc);
        g.drawImage(offscreen, 0, 0, this);
    }


    @Override
    public void paint(Graphics g) {
        if (image == null) {
            image = (BufferedImage) createImage(getSize().width, getSize().height);
            g2d = (Graphics2D) image.getGraphics();
        }
        g2d.setColor(Color.black);
        if (sendCanvasStateData != null) g2d.fillOval(sendCanvasStateData.getPoint().x,sendCanvasStateData.getPoint().y,10,10);
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
