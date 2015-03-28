package view.ui.display.impl.swing;

import model.manager.ManagerLobby;
import model.player.Player;
import view.persistence.impl.loaders.image.FactoryImageLoader;

import javax.swing.*;
import java.awt.*;

public class ResultDisplay extends JPanel implements view.ui.display.interfaces.ScoringDisplay {

    private final int HEIGHT=70;

    private JLabel playername;
    private Player player;

    public ResultDisplay (Player player) {
        super();
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder());
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
                setBackground(new Color(142,17,10));
                setBorder(BorderFactory.createEmptyBorder(0,10,5,0));
                add(new JLabel() {
                    {
                        setFont(new Font("Montserrat", Font.BOLD, 45));
                        if (ManagerLobby.myPlayer.equals(player))
                            setForeground(Color.YELLOW);
                        else
                            setForeground(Color.WHITE);
                        setText(String.valueOf(ManagerLobby.myLobby.getScoring().getPosition(player)));
                    }
                });
            }
        }, BorderLayout.WEST);
        add(new JPanel () {
            {
                setBackground(new Color(142,17,10));
                setLayout(new BorderLayout());
                add(new JPanel () {
                    {
                        setLayout(new FlowLayout(FlowLayout.LEFT));
                        add(new JLabel() {
                            {
                                setIcon(new ImageIcon(FactoryImageLoader.DEFAULT_PLAYER_IMAGE));
                            }
                        });
                        setOpaque(false);
                    }
                }, BorderLayout.WEST);
                add(new JPanel () {
                    {
                        setBackground(new Color(142,17,10));
                        add(createPlayerName());
                    }
                }, BorderLayout.SOUTH);
            }
        }, BorderLayout.CENTER);

        add(new JPanel () {
            {
                setBackground(new Color(142,17,10));
                add(createScore());
            }
        }, BorderLayout.EAST);
    }

    private Component createScore() {
        return new JLabel() {
            {
                if (ManagerLobby.myPlayer.equals(player))
                    setForeground(Color.YELLOW);
                else
                    setForeground(Color.WHITE);
                setFont(new Font("Montserrat", Font.BOLD, 20));
                setText(String.valueOf(ManagerLobby.myLobby.getScoring().getScore(player).getScore()));
            }
        };
    }

    private Component createPlayerName() {
        return playername = new JLabel() {
            {
                if (ManagerLobby.myPlayer.equals(player))
                    setForeground(Color.YELLOW);
                else
                    setForeground(Color.WHITE);
                setFont(new Font("Montserrat", Font.BOLD, 15));
                setText(player.getName());
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
