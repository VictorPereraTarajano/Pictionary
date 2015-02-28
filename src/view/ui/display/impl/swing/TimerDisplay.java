package view.ui.display.impl.swing;

import model.manager.ManagerLobby;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TimerDisplay extends JPanel implements view.ui.display.interfaces.TimerDisplay{

    private BufferedImage image;
    private Graphics2D g2d;
    private Color backgroundColor;

    private JLabel timer;

    public TimerDisplay() {
        super();
        setBorder(new EmptyBorder(10,15,15,15));
        createWidgets();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image == null) {
            image = (BufferedImage) createImage(getSize().width, getSize().height);
            g2d = (Graphics2D) image.getGraphics();
            clear();
        }
        applyChanges(g2d);
        g.drawImage(image, 0, 0, this);
    }

    private void clear() {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(backgroundColor);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(Color.WHITE);
        g2d.fillOval(5, 5, getWidth() - 10, getHeight() - 10);
    }

    private void applyChanges(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(2));
        fillOval();
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawOval(5, 5, getWidth() - 10, getHeight() - 10);
    }

    public void fillOval () {
        int radius = (getWidth() / 2) - 5;
        int centerX = 5 + radius;
        int centerY = 5 + radius;
        int count = model.timer.Timer.initCount - ManagerLobby.myLobby.getTimer().getCount();
        int lineWidth = (int) Math.sqrt(Math.pow(radius, 2.0) - Math.pow(radius - count, 2.0));
        g2d.drawLine(centerX - lineWidth, centerY + radius - count, centerX + lineWidth, centerY + radius - count);
    }

    private void createWidgets() {
        add(createTimerLabel());
    }

    private Component createTimerLabel() {
        return timer = new JLabel(String.valueOf(ManagerLobby.myLobby.getTimer().getCount())) {
            {
                setForeground(Color.BLACK);
                setFont(new Font("Lobster", Font.BOLD, 40));
            }
        };
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(80,80);
    }

    @Override
    public void display() {
        timer.setText(String.valueOf(ManagerLobby.myLobby.getTimer().getCount()));
        repaint();
    }

    public void setBackgroundColor(Color color) {
        backgroundColor=color;
    }
}
