package view.ui.frame.impl.swing;

import controller.impl.command.player.InvitePlayerCommand;
import controller.impl.command.player.KickPlayerCommand;
import controller.impl.sendcommand.SendMessageCommand;
import model.game.Lobby;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.message.impl.CloseLobbyMessage;
import model.message.impl.HostMigrationMessage;
import model.message.impl.StartGameMessage;
import model.messagedata.impl.CloseLobbyData;
import model.messagedata.impl.HostMigrationData;
import model.messagedata.impl.StartGameData;
import view.ui.viewers.impl.swing.canvaspanel.CanvasPanel;
import view.ui.viewers.impl.swing.chatpanel.ChatPanel;
import view.ui.viewers.impl.swing.scoringpanel.ScoringPanel;
import view.ui.viewers.impl.swing.timerpanel.TimerPanel;
import view.ui.viewers.impl.swing.wordpanel.WordPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LobbyFrame extends JFrame implements view.ui.frame.interfaces.LobbyFrame {

    private static final String TITLE ="Pictionary";
    private static final int WIDTH=1024, HEIGHT=720;

    private ScoringPanel scoringPanel;
    private ChatPanel chatPanel;
    private CanvasPanel canvasPanel;
    private TimerPanel timerPanel;
    private WordPanel wordPanel;

    public LobbyFrame() {
        super(TITLE);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        createMenu();
        createWidgets();
        createListeners();
        setVisible(true);
    }

    private void createListeners() {
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                MenuFrame.menuFrame.setVisible(true);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                MenuFrame.menuFrame.setVisible(true);
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
        JMenuBar menu = new JMenuBar();
        menu.add(invitePlayerOption());
        menu.add(kickPlayerOption());
        menu.add(startGameOption());
        menu.add(closeGameOption());
        setJMenuBar(menu);
    }

    private void createWidgets() {
        add(createScoringPanel());
        add(createCanvasPanel());
        add(createChatPanel());
        add(createTimerPanel());
        add(createWordPanel());
        add(createLogLabel());
    }

    private Component createWordPanel() {
        wordPanel=new WordPanel();
        return wordPanel;
    }

    private Component createTimerPanel() {
        timerPanel=new TimerPanel();
        return timerPanel;
    }

    private Component closeGameOption() {
        JMenuItem closeGameOption = new JMenuItem("Close Lobby");
        closeGameOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ManagerLobby.host.equals(ManagerLobby.myPlayer))
                    new SendMessageCommand(new HostMigrationMessage(new HostMigrationData(ManagerLobby.getAnotherHost(),ManagerLobby.myLobby)), ManagerConnection.TCPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers())).execute();
                else
                    new SendMessageCommand(new CloseLobbyMessage(new CloseLobbyData(ManagerLobby.myPlayer)), ManagerConnection.TCPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers())).execute();
                ManagerLobby.myLobbyFrame.setVisible(false);
            }
        });
        return closeGameOption;
    }

    private Component startGameOption() {
        JMenuItem startGameOption = new JMenuItem("Start Game");
        startGameOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SendMessageCommand(new StartGameMessage(new StartGameData()), ManagerConnection.TCPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers())).execute();
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
        JLabel logLabel = new JLabel(" Connected");
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
        scoringPanel.refresh();
    }

}
