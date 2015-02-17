package view.ui.display.impl.swing;

import model.manager.ManagerLobby;
import model.messagedata.impl.KickPlayerData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KickPlayerDisplay extends JDialog implements view.ui.display.interfaces.KickPlayerDisplay {

    private KickPlayerData kickPlayerData;
    private JLabel message;

    public KickPlayerDisplay(KickPlayerData kickPlayerData) {
        super();
        this.kickPlayerData = kickPlayerData;
        createWidgets();
    }

    private void createWidgets() {
        add(createMessage());
        add(createAcceptButton());
    }

    private Component createAcceptButton() {
        return new JButton("OK") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ManagerLobby.myLobbyFrame.setVisible(false);
                        setVisible(false);
                    }
                });
            }
        };
    }

    private Component createMessage() {
        message=new JLabel(kickPlayerData.getMessage());
        return message;
    }

    @Override
    public void display() {
        setVisible(true);
    }
}
