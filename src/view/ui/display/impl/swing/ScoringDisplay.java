package view.ui.display.impl.swing;

import model.manager.ManagerLobby;
import model.player.Player;

import javax.swing.*;
import java.awt.*;

public class ScoringDisplay extends JPanel implements view.ui.display.interfaces.ScoringDisplay {

    private final int HEIGHT=50;

    private JLabel playername;
    private Player player;

    public ScoringDisplay(Player player) {
        super();
        setLayout(new GridLayout(1, 2));
        this.player = player;
        createWidgets();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(0,0,100,100);
        g.dispose();
    }

    private void createWidgets() {
        add(new JPanel () {
            {
                add(createScore());
            }
        });
        add(new JPanel () {
            {
                add(createPlayerName());
            }
        });
    }

    private Component createScore() {
        JLabel score;
        return score = new JLabel(String.valueOf(ManagerLobby.myLobby.getScoring().getScore(player).getScore())) {
            {
                this.setFont(new Font("Lobster", Font.BOLD, 30));
            }
        };
    }

    private Component createPlayerName() {
        return playername = new JLabel(player.getName()){
            {
                this.setFont(new Font("Lobster", Font.BOLD, 30));
            }
        };
    }

    @Override
    public void refresh() {
        playername.setText(player.getName()+","+ ManagerLobby.myLobby.getScoring().getScore(player).getScore());
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(ManagerLobby.myLobbyFrame.getScoringPanel().getWidth(), HEIGHT);
    }

    @Override
    public void setPlayer (Player player) {
        this.player=player;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }
}
