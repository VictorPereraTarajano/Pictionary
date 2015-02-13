package view.ui.frame.impl.swing;

import controller.impl.command.connection.ConnectCommand;
import controller.impl.command.connection.DisconnectCommand;
import controller.impl.command.lobby.CreateLobbyCommand;
import controller.impl.command.player.RegisterPlayerCommand;
import model.manager.ManagerConnection;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame{

    private static final int WIDTH=250,HEIGHT=200;
    private static final String TITLE="Menu";

    public static MenuFrame menuFrame;
    private JLabel log;
    private JButton createLobbyButton;

    public MenuFrame() {
        super(TITLE);
        menuFrame=this;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        createWidgets();
        setLocation(500,500);
        setVisible(true);
    }

    private void createWidgets() {
        add(createPanelButtons(), BorderLayout.CENTER);
        add(createLogLabel(), BorderLayout.SOUTH);
    }

    private JPanel createPanelButtons() {
        return new JPanel() {
            {
                add(createRegisterPlayerButton());
                add(createLobbyButton());
                add(createExitButton());
                add(createConnectDisconnectButton());
                setLayout(new GridLayout(4,1));
            }
        };
    }

    private Component createLogLabel() {
        log = new JLabel(ManagerConnection.getStatus());
        return log;
    }

    private Component createConnectDisconnectButton() {
        return new JButton("Connect") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (ManagerConnection.getStatus().equals("CONNECTED")) {
                            new DisconnectCommand().execute();
                            log.setText(ManagerConnection.getStatus());
                            setText("Connect");
                        } else {
                            new ConnectCommand().execute();
                            log.setText(ManagerConnection.getStatus());
                            setText("Disconnect");
                        }
                    }
                });
            }
        };
    }

    private Component createExitButton() {
        return new JButton("Exit") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuFrame.dispose();
                    }
                });
            }
        };
    }

    private Component createRegisterPlayerButton() {
        return new JButton("Register Playername") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new RegisterPlayerCommand().execute();
                        setEnabled(true);
                        setText("Change Playername");
                    }
                });
            }
        };
    }

    private Component createLobbyButton() {
        return new JButton("Create Lobby"){
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        new CreateLobbyCommand().execute();
                    }
                });
            }
        };
    }
}
