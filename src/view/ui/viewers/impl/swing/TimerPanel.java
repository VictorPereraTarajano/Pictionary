package view.ui.viewers.impl.swing;

import view.ui.display.impl.swing.TimerDisplay;

import javax.swing.*;
import java.awt.*;

public class TimerPanel extends JPanel implements view.ui.viewers.interfaces.TimerPanel {

    private TimerDisplay timerDisplay;

    public TimerPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Timer Panel"));
        createWidgets();
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
