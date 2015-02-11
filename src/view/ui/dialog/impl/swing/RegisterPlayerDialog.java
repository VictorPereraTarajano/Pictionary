package view.ui.dialog.impl.swing;

import model.net.manager.ManagerConnection;
import model.player.Player;
import view.ui.frame.impl.swing.LobbyFrame;
import view.ui.frame.impl.swing.MenuFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPlayerDialog extends JDialog implements view.ui.dialog.interfaces.RegisterPlayerDialog{

    private JTextField playerNameField;
    private JTextField ipField;
    private JButton acceptButton;
    private JButton cancelButton;

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
        add(new JLabel(" Your player name : "));
        add(createPlayerNameField());
        add(createCancelButton());
        add(createAcceptButton());
    }

    private Component createCancelButton() {
        cancelButton=new JButton("CANCEL");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        return cancelButton;
    }

    private Component createAcceptButton() {
        acceptButton=new JButton("OK");
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerNameField.getText().trim().isEmpty())
                    new JOptionPane().showMessageDialog(RegisterPlayerDialog.mySelf,
                            "Your playername is empty !!",
                            "Failed to register",
                            JOptionPane.WARNING_MESSAGE);
                else {
                    LobbyFrame.myPlayer = getPlayer();
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
