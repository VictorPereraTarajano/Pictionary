package view.ui.display.impl.swing;

import model.manager.ManagerLobby;

import javax.swing.*;
import java.awt.*;

public class TimerDisplay extends JPanel implements view.ui.display.interfaces.TimerDisplay{

    private JLabel timer;

    public TimerDisplay() {
        super();
        createWidgets();
        setBackground(new Color(250,56,56));
    }

    private void createWidgets() {
        add(createTimerLabel());
    }

    private Component createTimerLabel() {
        return timer = new JLabel(String.valueOf(ManagerLobby.myLobby.getTimer().getCount())) {
            {
                this.setFont(new Font("Lobster", Font.BOLD, 25));
            }
        };
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200,50);
    }

    @Override
    public void display() {
        timer.setText(String.valueOf(ManagerLobby.myLobby.getTimer().getCount()));
    }
}
