package view.frame.impl.swing;

import controller.impl.lobby.CreateLobbyCommand;
import model.game.Lobby;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{

    private static final int WIDTH=500,HEIGHT=500;
    private static final String TITLE="Menu";
    private JButton createLobby;

    public MainFrame() {
        super(TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        createWidgets();
        setVisible(true);
    }

    private void createWidgets() {
        add(createLobbyButton());
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
        return createLobby;
    }
}
