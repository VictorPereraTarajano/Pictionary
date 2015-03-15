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
        setLayout(new GridLayout(1,2));
        this.player = player;
        createWidgets();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void createWidgets() {
        add(new JPanel () {
            {
                add(createScore());
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, this.getWidth(), getHeight());
                g.setColor(Color.LIGHT_GRAY);
                g.fillRoundRect(0, 0, this.getWidth(), getHeight(), 10, 10);
                g.fillRect(getWidth()- 50, 0, getWidth(), getHeight());
            }
        }, BorderLayout.EAST);
        add(new JPanel () {
            {
                add(createPlayerName());
            }
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, this.getWidth(), getHeight());
                g.setColor(Color.LIGHT_GRAY);
                g.fillRoundRect(0, 0, this.getWidth(), getHeight(), 10, 10);
                g.fillRect(0, 0, 50, getHeight());
            }
        }, BorderLayout.WEST);
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
        return playername = new JLabel(player.getName()) {
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
