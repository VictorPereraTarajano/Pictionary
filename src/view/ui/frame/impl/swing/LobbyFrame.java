package view.ui.frame.impl.swing;

import controller.impl.command.player.InvitePlayerCommand;
import controller.impl.command.player.KickPlayerCommand;
import model.game.GameBuilder;
import model.manager.ManagerGame;
import model.manager.ManagerLobby;
import model.manager.ManagerMenu;
import view.ui.viewers.impl.swing.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class LobbyFrame extends JFrame implements view.ui.frame.interfaces.LobbyFrame {

    private static final String TITLE ="Pictionary";
    private static final int WIDTH=1280, HEIGHT=720;
    private final Color backgroundColor=new Color(105, 202, 136);

    private ScoringPanel scoringPanel;
    private ChatPanel chatPanel;
    private CanvasPanel canvasPanel;
    private TimerPanel timerPanel;
    private WordPanel wordPanel;

    private JLabel logLabel;

    public LobbyFrame() {
        super(TITLE);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setIcon();
        setLayout(new BorderLayout());
        createMenu();
        createWidgets();
        createListeners();
        setBackgroundColor(backgroundColor);
    }

    private void setIcon() {
        try {
            setIconImage(ImageIO.read(getClass().getResource("/pinturillo.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createListeners() {
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                ManagerMenu.menuFrame.setVisible(true);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                ManagerMenu.menuFrame.setVisible(true);
            }

            @Override
            public void windowIconified(WindowEvent e)  {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar() {
            {
                setBorder(null);
            }
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(30,30);
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                super.paintComponent(g2d);
                g2d.setPaint(Color.DARK_GRAY);
                g2d.fillRect(0,0,getWidth(),60);
            }
        };
        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.X_AXIS));
        menuBar.add(invitePlayerOption());
        menuBar.add(kickPlayerOption());
        menuBar.add(startGameOption());
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(closeGameOption());
        setJMenuBar(menuBar);
    }

    private void createWidgets() {
        add(new JPanel() {
            {
                setBorder(new EmptyBorder(10,0,0,0));
                setBackground(backgroundColor);
                setLayout(new BorderLayout());
                add(new JPanel(){
                    {
                        setLayout(new BorderLayout());
                        add(createScoringPanel(), BorderLayout.CENTER);
                        add(createTimerPanel(), BorderLayout.NORTH);
                    }
                }, BorderLayout.WEST);
                add(new JPanel() {
                    {
                        setLayout(new BorderLayout());
                        setBackground(backgroundColor);
                        add(createCanvasPanel(), BorderLayout.CENTER);
                        add(createWordPanel(), BorderLayout.NORTH);
                    }
                }, BorderLayout.CENTER);
                add(createChatPanel(), BorderLayout.EAST);
            }
        }, BorderLayout.CENTER);
        add(new JPanel () {
            {
                setLayout(new FlowLayout(FlowLayout.LEFT));
                add(createLogLabel());
                setBackground(Color.DARK_GRAY);
            }
        }, BorderLayout.SOUTH);
    }

    private Component createWordPanel() {
        return wordPanel=new WordPanel();
    }

    private Component createTimerPanel() {
        return timerPanel=new TimerPanel() {
            @Override
            public Dimension getMaximumSize() {
                return new Dimension(100,100);
            }
        };
    }

    private JMenu closeGameOption() {
        JMenu closeGameOption = new JMenu("Close Lobby");
        closeGameOption.setForeground(Color.WHITE);
        closeGameOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*if (ManagerLobby.myLobby.host.equals(ManagerLobby.myPlayer) && ManagerLobby.myLobby.getScoring().getPlayers().length>1)
                    new SendMessageCommand(new HostMigrationMessage(new HostMigrationData(ManagerLobby.getAnotherHost(), ManagerLobby.myLobby)), ManagerConnection.TCPBroadcast()).execute();
                else
                    new SendMessageCommand(new CloseLobbyMessage(new CloseLobbyData(ManagerLobby.myPlayer)), ManagerConnection.TCPBroadcast()).execute();*/
                ManagerLobby.myLobbyFrame.setVisible(false);
                ManagerMenu.menuFrame.setVisible(true);
            }
        });
        return closeGameOption;
    }

    private JMenu startGameOption() {
        JMenu startGameOption = new JMenu("Start Game");
        startGameOption.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                if (ManagerLobby.myLobby.getScoring().size() >= ManagerGame.MIN_NUM_PLAYERS && ManagerLobby.myLobby.host.equals(ManagerLobby.myPlayer)) {
                    ManagerLobby.myLobby.setGame(new GameBuilder().load());
                  //  new SendMessageCommand(new SendTurnStateMessage(new SendTurnStateData(ManagerLobby.myLobby.getGame().nextTurn())), ManagerConnection.TCPBroadcast()).execute();
                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        startGameOption.setForeground(Color.WHITE);
        startGameOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ManagerLobby.myLobby.getScoring().size() >= ManagerGame.MIN_NUM_PLAYERS && ManagerLobby.myLobby.host.equals(ManagerLobby.myPlayer)) {
                    ManagerLobby.myLobby.setGame(new GameBuilder().load());
                    //new SendMessageCommand(new SendTurnStateMessage(new SendTurnStateData(ManagerLobby.myLobby.getGame().nextTurn())), ManagerConnection.TCPBroadcast()).execute();
                }
                }
        });
        return startGameOption;
    }

    private JMenu invitePlayerOption() {
        JMenu invitePlayerOption = new JMenu("Invite Player");
        invitePlayerOption.setForeground(Color.WHITE);
        invitePlayerOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InvitePlayerCommand().execute();
            }
        });
        invitePlayerOption.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                new InvitePlayerCommand().execute();
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        return invitePlayerOption;
    }

    private JMenu kickPlayerOption() {
        JMenu kickPlayerOption = new JMenu("Kick Player");
        kickPlayerOption.setForeground(Color.WHITE);
        kickPlayerOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KickPlayerCommand().execute();
            }
        });
        return kickPlayerOption;
    }

    private Component createLogLabel() {
        return logLabel = new JLabel(" Connected") {
            {
                setForeground(Color.WHITE);
            }
        };
    }

    private Component createChatPanel() {
        return chatPanel=new ChatPanel();
    }

    private Component createCanvasPanel() {
        canvasPanel= new CanvasPanel();
        return canvasPanel;
    }

    private Component createScoringPanel() {
        return scoringPanel=new ScoringPanel();
    }

    public JLabel getLogLabel() {
        return logLabel;
    }

    @Override
    public CanvasPanel getCanvasPanel() {
        return this.canvasPanel;
    }

    @Override
    public ChatPanel getChatPanel() {
        return chatPanel;
    }

    @Override
    public ScoringPanel getScoringPanel() {
        return scoringPanel;
    }

    @Override
    public TimerPanel getTimerPanel() {
        return timerPanel;
    }

    @Override
    public WordPanel getWordPanel() {
        return wordPanel;
    }

    public void setBackgroundColor (Color color) {
        canvasPanel.setBackgroundColor(color);
        chatPanel.setBackgroundColor(color);
        scoringPanel.setBackgroundColor(color);
        timerPanel.setBackgroundColor(color);
        wordPanel.setBackgroundColor(color);
    }

}
