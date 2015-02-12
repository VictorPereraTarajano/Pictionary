package view.ui.frame.impl.swing;

import controller.impl.command.connection.ConnectCommand;
import controller.impl.command.connection.DisconnectCommand;
import controller.impl.command.lobby.CreateLobbyCommand;
import controller.impl.command.player.RegisterPlayerCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame{

    private static final int WIDTH=250,HEIGHT=100;
    private static final String TITLE="Menu";

    private JButton createLobby;
    private JButton registerPlayer;
    private JButton exitButton;
    private JButton connectButton;
    private JButton disconnectButton;

    public static MenuFrame menuFrame;

    public MenuFrame() {
        super(TITLE);
        menuFrame=this;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        createWidgets();
        setLayout(new GridLayout(5,1));
        setLocation(500,500);
        setVisible(true);
    }

    private void createWidgets() {
        add(createRegisterPlayerButton());
        add(createLobbyButton());
        add(createExitButton());
        add(createConnectButton());
        add(createDisconnectButton());
    }

    private Component createConnectButton() {
        connectButton= new JButton("Connect");
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConnectCommand().execute();
                connectButton.setEnabled(false);
            }
        });
        return connectButton;
    }

    private Component createDisconnectButton() {
        disconnectButton= new JButton("Disconnect");
        disconnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisconnectCommand().execute();
                disconnectButton.setEnabled(false);
            }
        });
        return disconnectButton;
    }

    private Component createExitButton() {
        exitButton= new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.dispose();
            }
        });
        return exitButton;
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
