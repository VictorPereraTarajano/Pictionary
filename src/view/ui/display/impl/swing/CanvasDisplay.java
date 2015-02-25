package view.ui.display.impl.swing;

import model.manager.ManagerLobby;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;

public class CanvasDisplay extends JPanel implements view.ui.display.interfaces.CanvasDisplay {

    private Graphics2D g2d;
    public BufferedImage image = null;

    public CanvasDisplay() {
        super();
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 10, true));
        addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                //image = image.getScaledInstance(((JPanel) e.getSource()).getWidth(), ((JPanel) e.getSource()).getHeight(), Image.SCALE_SMOOTH);
                g2d = (Graphics2D) image.getGraphics();
                System.out.println("asd");
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        if (image == null) {
            image = (BufferedImage) createImage(getSize().width, getSize().height);
            g2d = (Graphics2D) image.getGraphics();
            clear();
        }
        applyChanges(g2d);
        g.drawImage(image, 0, 0, this);
    }

    private void applyChanges(Graphics2D g) {
        g.setColor(ManagerLobby.myLobby.getCanvas().getPencil().getColor());
        g.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        for (Point point : ManagerLobby.myLobby.getCanvas().getPointList().toArray(new Point [ManagerLobby.myLobby.getCanvas().getPointList().size()]))
            g.fillOval(point.x, point.y, ManagerLobby.myLobby.getCanvas().getPencil().getDimension().width,ManagerLobby.myLobby.getCanvas().getPencil().getDimension().height);
        ManagerLobby.myLobby.getCanvas().clear();
    }

    public void clear () {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(250,56,56));
        g2d.fillRect(0,0,getSize().width,getSize().height);
        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(0, 0, this.getSize().width, this.getSize().height, 25, 25);
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
