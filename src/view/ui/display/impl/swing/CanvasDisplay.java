package view.ui.display.impl.swing;

import model.manager.ManagerLobby;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class CanvasDisplay extends JPanel implements view.ui.display.interfaces.CanvasDisplay {

    private Graphics2D g2d;
    public BufferedImage image = null;

    public CanvasDisplay() {
        super();
    }

    @Override
    public void update(Graphics g) {
        paintComponent(g);
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        if (image == null)
            initComponents();
        applyChanges(g2d);
        g.drawImage(image, 0, 0, this);
    }

    private void initComponents () {
        image = (BufferedImage) createImage(getSize().width, getSize().height);
        g2d = (Graphics2D) image.getGraphics();
        clear();
    }

    public void drawString (String number) {
        g2d.setFont(new Font("Montserrat" , Font.BOLD, 400));
        FontMetrics fm = getFontMetrics(g2d.getFont());
        Rectangle2D textsize = fm.getStringBounds(number, g2d);
        int xPos = (int) ((getSize().width - textsize.getWidth()) / 2);
        int yPos = (int) ((getSize().height - textsize.getHeight()) / 2 + fm.getAscent());
        g2d.drawString(number, xPos, yPos);
        repaint();
    }

    private void applyChanges(Graphics2D g) {
        g.setColor(ManagerLobby.myLobby.getCanvas().getPencil().getColor());
        g.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        for (Point point : ManagerLobby.myLobby.getCanvas().getPointList().toArray(new Point [ManagerLobby.myLobby.getCanvas().getPointList().size()]))
            g.fillOval(point.x, point.y, ManagerLobby.myLobby.getCanvas().getPencil().getDimension().width,ManagerLobby.myLobby.getCanvas().getPencil().getDimension().height);
        ManagerLobby.myLobby.getCanvas().clear();
    }

    private void clear () {
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
