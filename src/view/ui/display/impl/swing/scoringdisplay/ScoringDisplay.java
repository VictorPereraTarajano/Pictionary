package view.ui.display.impl.swing.scoringdisplay;

import model.player.Player;

import javax.swing.*;
import java.awt.*;

public class ScoringDisplay extends JPanel implements view.ui.display.interfaces.scoringdisplay.ScoringDisplay {

    private JLabel playername;
    private Player player;

    public ScoringDisplay(Player player) {
        super();
        this.player=player;
        createWidgets();
    }

    private void createWidgets() {
        add(createPlayerName());
    }

    private Component createPlayerName() {
        playername = new JLabel(this.player.getName());
        return playername;
    }

    @Override
    public void display(Player player) {
        playername.setText(player.getName());
    }
}
