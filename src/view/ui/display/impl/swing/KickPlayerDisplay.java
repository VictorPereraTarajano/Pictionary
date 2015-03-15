package view.ui.display.impl.swing;

import model.manager.ManagerLobby;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KickPlayerDisplay extends JDialog implements view.ui.display.interfaces.KickPlayerDisplay {

    private String message;

    public KickPlayerDisplay(String message) {
        super();
        this.message = message;
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
        return new JLabel(message);
    }

    @Override
    public void display() {
        setVisible(true);
    }
}
