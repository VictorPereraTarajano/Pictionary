package view.ui.frame.impl.swing;

import controller.impl.command.lobby.CreateLobbyCommand;
import controller.impl.command.player.RegisterPlayerCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{

    private static final int WIDTH=250,HEIGHT=100;
    private static final String TITLE="Menu";

    private JButton createLobby;
    private JButton registerPlayer;

    public static MainFrame mainFrame;

    public MainFrame() {
        super(TITLE);
        mainFrame=this;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        createWidgets();
        setLayout(new GridLayout(2,1));
        setLocation(500,500);
        setVisible(true);
    }

    private void createWidgets() {
        add(createRegisterPlayerButton());
        add(createLobbyButton());
    }

    private Component createRegisterPlayerButton() {
        registerPlayer = new JButton("Register / Change Playername");
        registerPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterPlayerCommand().execute();
                createLobby.setEnabled(true);
            }
        });
        return registerPlayer;
    }

    private Component createLobbyButton() {
        createLobby = new JButton("Create Lobby");
        createLobby.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new CreateLobbyCommand().execute();
            }
        });
        createLobby.setEnabled(false);
        return createLobby;
    }
}
