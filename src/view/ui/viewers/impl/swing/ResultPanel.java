package view.ui.viewers.impl.swing;

import model.manager.ManagerLobby;
import model.player.Player;
import view.ui.display.impl.swing.ResultDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ResultPanel extends JPanel implements view.ui.viewers.interfaces.ScoringPanel {

    private List<ResultDisplay> resultDisplay;
    private Color backgroundColor;

    public ResultPanel() {
        super();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        createWidgets();
        setVisible(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g2d.setColor(backgroundColor);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillRect(0,0,getWidth(), getHeight());
        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(5, 5, getWidth() - 5, getHeight() - 15, 20, 20);
    }

    private void createWidgets() {
        resultDisplay= new ArrayList<>();
        for (int i  = 0; i < ManagerLobby.myLobby.getScoring().size(); i++)
            add(createScoringDisplay(ManagerLobby.myLobby.getScoring().getPlayers()[i]));
    }

    private ResultDisplay createScoringDisplay(Player player) {
        resultDisplay.add(new ResultDisplay(player));
        return resultDisplay.get(resultDisplay.size()-1);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200,200);
    }

    @Override
    public void refresh() {
        for (int i = 0; i < ManagerLobby.myLobby.getScoring().size(); i++) {
            if (resultDisplay.size() - 1 >= i)
                resultDisplay.get(i).setPlayer(ManagerLobby.myLobby.getScoring().getPlayers()[i]);
            else
                add(createScoringDisplay(ManagerLobby.myLobby.getScoring().getPlayers()[i]));
            resultDisplay.get(i).refresh();
        }
        for (int i = ManagerLobby.myLobby.getScoring().size(); i < resultDisplay.size(); i++) {
            remove(resultDisplay.get((i)));
            resultDisplay.remove(resultDisplay.get(i));
        }
        revalidate();
    }

    public void setBackgroundColor(Color color) {
        backgroundColor=color;
    }
}
