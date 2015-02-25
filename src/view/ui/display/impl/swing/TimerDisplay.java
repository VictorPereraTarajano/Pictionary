package view.ui.display.impl.swing;

import model.manager.ManagerLobby;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TimerDisplay extends JPanel implements view.ui.display.interfaces.TimerDisplay{

    private JLabel timer;

    public TimerDisplay() {
        super();
        setBorder(new EmptyBorder(20,5,5,5));
        createWidgets();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g2d.setColor(new Color(250, 56, 56));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillRect(0,0,getWidth(),getHeight());
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillOval(0, 0, getWidth(), getHeight());
    }

    private void createWidgets() {
        add(createTimerLabel());
    }

    private Component createTimerLabel() {
        return timer = new JLabel(String.valueOf(ManagerLobby.myLobby.getTimer().getCount())) {
            {
                setForeground(Color.WHITE);
                setFont(new Font("Lobster", Font.BOLD, 25));
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
    }
}
