package view.ui.viewers.impl.swing;

import model.manager.ManagerLobby;
import model.player.Player;
import view.ui.display.impl.swing.ScoringDisplay;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ScoringPanel extends JPanel implements view.ui.viewers.interfaces.ScoringPanel {

    private List<ScoringDisplay> scoringDisplay;

    public ScoringPanel() {
        super();
        setBorder(new EmptyBorder(10,10,10,10));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        createWidgets();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g2d.setColor(new Color(250, 56, 56));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillRect(0,0,getWidth(), getHeight());
        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(5,5,getWidth()-5, getHeight()-15,20,20);
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

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200,200);
    }

    @Override
    public void refresh() {
        for (int i = 0; i < ManagerLobby.myLobby.getScoring().size(); i++) {
            if (scoringDisplay.size() - 1 >= i)
                scoringDisplay.get(i).setPlayer(ManagerLobby.myLobby.getScoring().getPlayers()[i]);
            else
                add(createScoringDisplay(ManagerLobby.myLobby.getScoring().getPlayers()[i]));
            scoringDisplay.get(i).refresh();
        }
        for (int i = ManagerLobby.myLobby.getScoring().size(); i < scoringDisplay.size(); i++) {
            remove(scoringDisplay.get((i)));
            scoringDisplay.remove(scoringDisplay.get(i));
        }
        revalidate();
    }
}
