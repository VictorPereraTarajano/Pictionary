package view.ui.display.impl.swing;

import model.manager.ManagerLobby;

import javax.swing.*;
import java.awt.*;

public class TimerDisplay extends JPanel implements view.ui.display.interfaces.TimerDisplay{

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

    @Override
    public void display() {
        timer.setText(String.valueOf(ManagerLobby.myLobby.getTimer().getCount()));
    }
}
