package view.ui.frame.impl.swing;

import controller.impl.command.player.InvitePlayerCommand;
import controller.impl.command.player.KickPlayerCommand;
import controller.impl.sendcommand.SendMessageCommand;
import model.game.GameBuilder;
import model.manager.ManagerConnection;
import model.manager.ManagerGame;
import model.manager.ManagerLobby;
import model.manager.ManagerMenu;
import model.message.impl.CloseLobbyMessage;
import model.message.impl.HostMigrationMessage;
import model.messagedata.impl.CloseLobbyData;
import model.messagedata.impl.HostMigrationData;
import model.statemessage.impl.SendTurnStateMessage;
import model.statemessagedata.impl.SendTurnStateData;
import view.ui.viewers.impl.swing.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

public class LobbyFrame extends JFrame implements view.ui.frame.interfaces.LobbyFrame {

    private static final String TITLE ="Pictionary";
    private static final int WIDTH=1280, HEIGHT=720;

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
        getContentPane().setLayout(new BorderLayout());
        createMenu();
        createWidgets();
        createListeners();
        setBackground(Color.white);
    }

    private void setIcon() {
        try {
            setIconImage(ImageIO.read(new File("C:\\Users\\Victor\\Desktop\\pinturillo.png")));
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
            public void windowIconified(WindowEvent e) {

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
        JMenuBar menu = new JMenuBar() {
            {
                add(invitePlayerOption());
                add(kickPlayerOption());
                add(startGameOption());
                add(closeGameOption());
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.RED);
                g2d.drawImage(createImage(100,100),0,0, Color.blue, null);
                super.paintComponent(g);
            }
        };
        setJMenuBar(menu);
    }

    private void createWidgets() {
        add(new JPanel(){
            {
                setLayout(new BorderLayout());
                add(createWordPanel(), BorderLayout.CENTER);
                add(createTimerPanel(), BorderLayout.WEST);
            }
        }, BorderLayout.NORTH);
        add(new JPanel() {
            {
                setLayout(new BorderLayout());
                add(createScoringPanel(), BorderLayout.WEST);
                add(createCanvasPanel(), BorderLayout.CENTER);
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
        wordPanel=new WordPanel();
        return wordPanel;
    }

    private Component createTimerPanel() {
        timerPanel=new TimerPanel() {
            @Override
            public Dimension getMaximumSize() {
                return new Dimension(100,100);
            }
        };
        return timerPanel;
    }

    private Component closeGameOption() {
        JMenuItem closeGameOption = new JMenuItem("Close Lobby");
        closeGameOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ManagerLobby.myLobby.host.equals(ManagerLobby.myPlayer) && ManagerLobby.myLobby.getScoring().getPlayers().length>1)
                    new SendMessageCommand(new HostMigrationMessage(new HostMigrationData(ManagerLobby.getAnotherHost(), ManagerLobby.myLobby)), ManagerConnection.TCPBroadcast()).execute();
                else
                    new SendMessageCommand(new CloseLobbyMessage(new CloseLobbyData(ManagerLobby.myPlayer)), ManagerConnection.TCPBroadcast()).execute();
                ManagerLobby.myLobbyFrame.setVisible(false);
                ManagerMenu.menuFrame.setVisible(true);
            }
        });
        return closeGameOption;
    }

    private Component startGameOption() {
        JMenuItem startGameOption = new JMenuItem("Start Game");
        startGameOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ManagerLobby.myLobby.getScoring().size() >= ManagerGame.MIN_NUM_PLAYERS && ManagerLobby.myLobby.host.equals(ManagerLobby.myPlayer)) {
                    ManagerLobby.myLobby.setGame(new GameBuilder().load());
                    new SendMessageCommand(new SendTurnStateMessage(new SendTurnStateData(ManagerLobby.myLobby.getGame().nextTurn())), ManagerConnection.TCPBroadcast()).execute();
                }
                }
        });
        return startGameOption;
    }

    private Component invitePlayerOption() {
        JMenuItem invitePlayerOption = new JMenuItem("Invite Player");
        invitePlayerOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InvitePlayerCommand().execute();
            }
        });
        return invitePlayerOption;
    }

    private Component kickPlayerOption() {
        JMenuItem kickPlayerOption = new JMenuItem("Kick Player");
        kickPlayerOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KickPlayerCommand().execute();
            }
        });
        return kickPlayerOption;
    }

    private Component createLogLabel() {
        logLabel = new JLabel(" Connected") {
            {
                setForeground(Color.WHITE);
            }
        };
        return logLabel;
    }

    private Component createChatPanel() {
        chatPanel=new ChatPanel();
        return chatPanel;
    }

    private Component createCanvasPanel() {
        canvasPanel= new CanvasPanel();
        return canvasPanel;
    }

    private Component createScoringPanel() {
        scoringPanel=new ScoringPanel();
        return scoringPanel;
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

    @Override
    public void refresh() {
    }

}
