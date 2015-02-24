package view.ui.display.impl.swing;

import model.manager.ManagerLobby;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CanvasDisplay extends JPanel implements view.ui.display.interfaces.CanvasDisplay {

    private Graphics2D g2d;
    public BufferedImage image = null;

    public CanvasDisplay() {
        super();
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        if (image == null) {
            image = (BufferedImage) createImage(getSize().width, getSize().height);
            g2d = (Graphics2D) image.getGraphics();
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0,0,getSize().width,getSize().height);
        }
        applyChanges(g2d);
        g.drawImage(image, 0, 0, this);
    }

    private void applyChanges(Graphics g) {
        g.setColor(Color.BLACK);
        if (!ManagerLobby.myLobby.getCanvas().isEmpty())
            g.fillOval(ManagerLobby.myLobby.getCanvas().getLastPoint().x, ManagerLobby.myLobby.getCanvas().getLastPoint().y,10,10);
    }

    public void clear () {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0,0, getSize().width, getSize().height);
    }

    @Override
    public void display() {
        if (ManagerLobby.myLobby.getCanvas().isEmpty())
            clear();
        repaint();
    }

    public void setEditable(boolean editable) {
        setEnabled(editable);
    }

}
