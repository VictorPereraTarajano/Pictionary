package view.ui.viewers.impl.swing;

import model.manager.ManagerLobby;
import model.player.Player;
import view.ui.display.impl.swing.ScoringDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ScoringPanel extends JPanel implements view.ui.viewers.interfaces.ScoringPanel {

    private List<ScoringDisplay> scoringDisplay;

    public ScoringPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Scoring Panel"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        createWidgets();
    }

    private void createWidgets() {
        scoringDisplay= new ArrayList<>();
        for (int i  = 0; i < ManagerLobby.myLobby.getScoring().size(); i++)
            add(createScoringDisplay(ManagerLobby.myLobby.getScoring().getPlayers()[i]));
    }

    private ScoringDisplay createScoringDisplay(Player player) {
        scoringDisplay.add(new ScoringDisplay(player));
        return scoringDisplay.get(scoringDisplay.size()-1);
    }

    public ScoringDisplay exists (Player player) {
        for (int i =0 ;  i < scoringDisplay.size(); i++) {
            if (player.equals(scoringDisplay.get(i).getPlayer())) return scoringDisplay.get(i);
        }
        return null;
    }

    @Override
    public void refresh() {
        for (int i  = 0; i < ManagerLobby.myLobby.getScoring().size() ; i++) {
            ScoringDisplay sc = exists(ManagerLobby.myLobby.getScoring().getPlayers()[i]);
            if (sc == null) {
                add(createScoringDisplay(ManagerLobby.myLobby.getScoring().getPlayers()[i]));
            } else {
                sc.refresh();
            }
        }
        revalidate();
    }
}
