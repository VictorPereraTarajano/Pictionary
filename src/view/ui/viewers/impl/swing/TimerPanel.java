package view.ui.viewers.impl.swing;

import view.ui.display.impl.swing.TimerDisplay;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TimerPanel extends JPanel implements view.ui.viewers.interfaces.TimerPanel {

    private TimerDisplay timerDisplay;

    public TimerPanel() {
        super();
        setBorder(new EmptyBorder(10,10,10,10));
        createWidgets();
        setBackground(new Color(250,56,56));
    }

    private void createWidgets() {
        add(createTimerDisplay());
    }

    private Component createTimerDisplay() {
        timerDisplay=new TimerDisplay();
        return timerDisplay;
    }

    @Override
    public void refresh() {
        timerDisplay.display();
    }
}
