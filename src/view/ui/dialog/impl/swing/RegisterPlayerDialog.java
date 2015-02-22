package view.ui.dialog.impl.swing;

import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPlayerDialog extends JDialog implements view.ui.dialog.interfaces.RegisterPlayerDialog {

    private JTextField playerNameField;
    private JTextField ipField;

    private static JDialog mySelf;

    public RegisterPlayerDialog() {
        super();
        mySelf=this;
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        createWidgets();
        setLocation(500,500);
        setLayout(new GridLayout(2,2));
        setMinimumSize(new Dimension(300,100));
        setVisible(true);
    }

    private void createWidgets() {
        add(createPlayerLabel());
        add(createPlayerNameField());
        add(createCancelButton());
        add(createAcceptButton());
    }

    private JLabel createPlayerLabel() {
        return new JLabel(" Your player name : ");
    }

    private Component createCancelButton() {
        return new JButton("CANCEL"){
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mySelf.setVisible(false);
                    }
                });
            }
        };
    }

    private Component createAcceptButton() {
        return new JButton("OK") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (playerNameField.getText().trim().isEmpty())
                            new JOptionPane().showMessageDialog(mySelf, "Your playername is empty !!", "Failed to register", JOptionPane.WARNING_MESSAGE);
                        else {
                            ManagerLobby.myPlayer = getPlayer();
                            mySelf.setVisible(false);
                        }
                    }
                });
            }
        };
    }

    private Component createPlayerNameField() {
        playerNameField = new JTextField();
        playerNameField.setToolTipText("Your playername");
        return playerNameField;
    }

    @Override
    public Player getPlayer() {
        return new Player(playerNameField.getText(), ManagerConnection.DefaultIP);
    }
}
