package view.ui.frame.impl.swing;

import controller.impl.command.connection.ConnectCommand;
import controller.impl.command.connection.DisconnectCommand;
import controller.impl.command.lobby.CreateLobbyCommand;
import controller.impl.command.player.RegisterPlayerCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.manager.ManagerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame{

    private static final int WIDTH=250,HEIGHT=200;
    private static final String TITLE="Menu";

    private JLabel log;

    public MenuFrame() {
        super(TITLE);
        ManagerMenu.menuFrame=this;
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
                        ManagerMenu.menuFrame.dispose();
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
                        if (ManagerLobby.myPlayer!=null) {
                            setText("Change Playername");
                        }
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
                        new CreateLobbyCommand().execute();
                        ManagerLobby.myLobbyFrame.setVisible(true);
                        ManagerMenu.menuFrame.setVisible(false);
                    }
                });
            }
        };
    }
}
