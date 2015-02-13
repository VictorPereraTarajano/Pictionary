package view.ui.frame.impl.swing;

import controller.impl.command.game.StartGameCommand;
import controller.impl.command.connection.ConnectCommand;
import controller.impl.command.connection.DisconnectCommand;
import controller.impl.command.player.InvitePlayerCommand;
import controller.impl.command.player.KickPlayerCommand;
import model.game.Lobby;
import model.manager.ManagerConnection;
import model.player.Player;
import view.ui.viewers.impl.swing.CanvasPanel;
import view.ui.viewers.impl.swing.ChatPanel;
import view.ui.viewers.impl.swing.ScoringPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LobbyFrame extends JFrame implements view.ui.frame.interfaces.LobbyFrame {

    private static final String TITLE ="Pinturillo";
    private static final int WIDTH=1024, HEIGHT=720;

    private JMenuBar menu;
    private ScoringPanel scoringPanel;
    private ChatPanel chatPanel;
    private CanvasPanel canvasPanel;
    private JLabel logLabel;
    private Lobby lobby;

    public LobbyFrame(Lobby lobby) {
        super(TITLE);
        this.lobby=lobby;
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
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

    public Lobby getLobby() {
        return lobby;
    }

    private void createMenu() {
        menu = new JMenuBar();
        menu.add(invitePlayerOption());
        menu.add(kickPlayerOption());
        menu.add(startGameOption());
        menu.add(connectOption());
        menu.add(disconnectOption());
        setJMenuBar(menu);
    }

    private void createWidgets() {
        add(createScoringPanel(), BorderLayout.WEST);
        add(createCanvasPanel(), BorderLayout.CENTER);
        add(createChatPanel(), BorderLayout.EAST);
        add(createLogLabel(), BorderLayout.SOUTH);
    }

    private Component startGameOption() {
        JMenuItem startGameOption = new JMenuItem("Start Game");
        startGameOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StartGameCommand().execute();
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
                new KickPlayerCommand(lobby).execute();
            }
        });
        return kickPlayerOption;
    }

    private Component disconnectOption() {
        JMenuItem disconnectOption = new JMenuItem(ManagerConnection.getStatus());
        disconnectOption.setVisible(false);
        disconnectOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisconnectCommand().execute();
                ((JMenuItem) e.getSource()).setVisible(false);
                (menu.getComponent(menu.getMenuCount()-2)).setVisible(true);
                logLabel.setText(" Disconnected");
            }
        });
        return disconnectOption;
    }

    private Component connectOption() {
        JMenuItem connectOption = new JMenuItem("Connect");
        connectOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConnectCommand().execute();
                ((JMenuItem) e.getSource()).setVisible(false);
                (menu.getComponent(menu.getMenuCount()-1)).setVisible(true);
                logLabel.setText(" Connected");
            }
        });
        return connectOption;
    }

    private Component createLogLabel() {
        logLabel=new JLabel(" Disconnected");
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
}
