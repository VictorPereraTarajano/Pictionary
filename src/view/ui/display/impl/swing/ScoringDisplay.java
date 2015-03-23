package view.ui.display.impl.swing;

import model.manager.ManagerLobby;
import model.player.Player;
import view.persistence.impl.loaders.image.FactoryImageLoader;

import javax.swing.*;
import java.awt.*;

public class ScoringDisplay extends JPanel implements view.ui.display.interfaces.ScoringDisplay {

    private final int HEIGHT=70;

    private JLabel playername;
    private Player player;

    public ScoringDisplay(Player player) {
        super();
        setLayout(new BorderLayout());
        this.player = player;
        createWidgets();
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void createWidgets() {
        add(new JPanel () {
            {
                setBackground(Color.WHITE);
                setBorder(BorderFactory.createEmptyBorder(0,10,5,0));
                add(new JLabel() {
                    {
                        setFont(new Font("Montserrat", Font.BOLD, 45));
                        if (ManagerLobby.myPlayer.equals(player))
                            setForeground(Color.RED);
                        else
                            setForeground(Color.LIGHT_GRAY);
                        setText(String.valueOf(ManagerLobby.myLobby.getScoring().getPosition(ManagerLobby.myPlayer)));
                    }
                });
            }
        }, BorderLayout.WEST);
        add(new JPanel () {
            {
                setBackground(Color.WHITE);
                setLayout(new BorderLayout());
                add(new JPanel () {
                    {
                        setLayout(new FlowLayout(FlowLayout.LEFT));
                        add(new JLabel() {
                            {
                                setIcon(new ImageIcon(FactoryImageLoader.DEFAULT_PLAYER_IMAGE));
                            }
                        });
                        add(new JLabel() {
                            {
                                setIcon(new ImageIcon(FactoryImageLoader.STAR));
                            }
                        });
                        setOpaque(false);
                    }
                }, BorderLayout.WEST);
                add(new JPanel () {
                    {
                        setBackground(Color.WHITE);
                        add(createPlayerName());
                    }
                }, BorderLayout.SOUTH);
            }
        }, BorderLayout.CENTER);

        add(new JPanel () {
            {
                setBackground(Color.WHITE);
                add(createScore());
            }
        }, BorderLayout.EAST);
    }

    private Component createScore() {
        return new JLabel(String.valueOf(ManagerLobby.myLobby.getScoring().getScore(player).getScore())) {
            {
                this.setFont(new Font("Montserrat", Font.BOLD, 20));
            }
        };
    }

    private Component createPlayerName() {
        return playername = new JLabel() {
            {
                setFont(new Font("Montserrat", Font.BOLD, 15));
                setForeground(Color.RED);
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
