package view.ui.viewers.impl.swing.scoringpanel;

import model.manager.ManagerLobby;
import view.ui.display.impl.swing.scoringdisplay.ScoringDisplay;

import javax.swing.*;
import java.awt.*;

public class ScoringPanel extends JPanel implements view.ui.viewers.interfaces.scoringpanel.ScoringPanel {

    private ScoringDisplay [] scoringDisplay;

    public ScoringPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Scoring Panel"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        createWidgets();
    }

    private void createWidgets() {
        scoringDisplay= new ScoringDisplay [ManagerLobby.myLobby.getPlayerSet().length()];
        for (int i  = 0; i < scoringDisplay.length; i++)
            add(createScoringDisplay(i));
    }

    private Component createScoringDisplay(int i) {
        scoringDisplay[i]= new ScoringDisplay(ManagerLobby.myLobby.getPlayerSet().get(i));
        return scoringDisplay[i];
    }

    @Override
    public void refresh() {
        removeAll();
        createWidgets();
        revalidate();
        repaint();
    }
}
