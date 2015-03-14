package view.ui.frame.impl.swing;

import controller.impl.command.connection.ConnectCommand;
import controller.impl.command.connection.DisconnectCommand;
import controller.impl.command.lobby.CreateLobbyCommand;
import controller.impl.command.player.RegisterPlayerCommand;
import model.game.Lobby;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.manager.ManagerMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuFrame extends JFrame {

    private static final int WIDTH=250,HEIGHT=200;
    private static final String TITLE="Menu Pictionary";

    private JLabel log;

    public MenuFrame() {
        super(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIcon();
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        createWidgets();
        setLocation(500,500);
    }

    private void setIcon() {
        try {
            setIconImage(ImageIO.read(getClass().getResource("/pinturillo.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        return log = new JLabel(ManagerConnection.getStatus());
    }

    private Component createConnectDisconnectButton() {
        return new JButton("Connect") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (ManagerConnection.getStatus().equals("CONNECTED")) {
                            new DisconnectCommand().execute();
                            setText("Connect");
                        } else {
                            new ConnectCommand().execute();
                            setText("Disconnect");
                        }
                        log.setText(ManagerConnection.getStatus());
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
                        System.exit(0);
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
                        if (ManagerLobby.myPlayer!=null) setText("Change Playername");
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
                        new CreateLobbyCommand(new Lobby()).execute();
                        ManagerLobby.myLobbyFrame.setVisible(true);
                        ManagerMenu.menuFrame.setVisible(false);
                    }
                });
                setEnabled(false);
            }
        };
    }
}
