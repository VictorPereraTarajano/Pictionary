package view.ui.dialog.impl.swing;

import model.manager.ManagerConnection;
import model.player.Player;
import model.manager.ManagerLobby;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPlayerDialog extends JDialog implements view.ui.dialog.interfaces.RegisterPlayerDialog{

    private JTextField playerNameField;

    private static JDialog mySelf;

    public RegisterPlayerDialog() {
        super();
        mySelf=this;
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        createWidgets();
        setLocation(500,500);
        setLayout(new GridLayout(2,2));
        setMinimumSize(new Dimension(300,80));
        setVisible(true);
    }

    private void createWidgets() {
        add(createLabel());
        add(createPlayerNameField());
        add(createCancelButton());
        add(createAcceptButton());
    }

    private JLabel createLabel() {
        return new JLabel(" Your player name : ");
    }

    private Component createCancelButton() {
        JButton cancelButton = new JButton("CANCEL");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        return cancelButton;
    }

    private Component createAcceptButton() {
        JButton acceptButton = new JButton("OK");
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerNameField.getText().trim().isEmpty())
                    new JOptionPane().showMessageDialog(RegisterPlayerDialog.mySelf, "Your playername is empty !!", "Failed to register", JOptionPane.WARNING_MESSAGE);
                else {
                    ManagerLobby.myPlayer = getPlayer();
                    setVisible(false);
                }
            }
        });
        return acceptButton;
    }

    private Component createPlayerNameField() {
        playerNameField = new JTextField();
        return playerNameField;
    }

    @Override
    public Player getPlayer() {
        return new Player(playerNameField.getText(), ManagerConnection.DefaultIP);
    }
}
