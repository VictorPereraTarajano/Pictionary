package view.ui.viewers.impl.swing;

import view.ui.display.impl.swing.ScoringDisplay;
import model.manager.ManagerLobby;
import javax.swing.*;
import java.awt.*;

public class ScoringPanel extends JPanel implements view.ui.viewers.interfaces.ScoringPanel{

    private ScoringDisplay [] scoringDisplay;

    public ScoringPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Scoring Panel"));
        createWidgets();
    }

    private void createWidgets() {
        scoringDisplay= new ScoringDisplay [ManagerLobby.myLobby.getPlayerSet().length()];
        for (int i  = 0; i < scoringDisplay.length; i++)
            add(createScoringDisplay());
    }

    private Component createScoringDisplay() {
        return new ScoringDisplay();
    }

    @Override
    public ScoringDisplay [] getScoringDisplay() {
        return scoringDisplay;
    }
}
