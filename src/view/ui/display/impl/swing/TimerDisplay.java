package view.ui.display.impl.swing;

import model.manager.ManagerLobby;

import javax.swing.*;
import java.awt.*;

public class TimerDisplay extends JPanel {

    private JLabel timer;

    public TimerDisplay() {
        super();
        createWidgets();
    }

    private void createWidgets() {
        add(createTimerLabel());
    }

    private Component createTimerLabel() {
        timer = new JLabel(String.valueOf(ManagerLobby.myLobby.getTimer().getCount()));
        return timer;
    }

    public void display() {
        timer.setText(String.valueOf(ManagerLobby.myLobby.getTimer().getCount()));
    }
}
