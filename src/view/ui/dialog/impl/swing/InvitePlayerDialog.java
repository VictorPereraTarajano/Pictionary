package view.ui.dialog.impl.swing;

import controller.impl.sendcommand.SendMessageCommand;
import model.game.Lobby;
import model.message.impl.InvitePlayerMessage;
import model.messagedata.impl.InvitePlayerData;
import model.net.sender.impl.TCPSender;
import model.manager.ManagerLobby;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvitePlayerDialog extends JDialog implements view.ui.dialog.interfaces.InvitePlayerDialog {

    private static final int MAX_COLUMNS=20;
    private static final int WIDTH=300, HEIGHT=100;

    private JTextField ipField;
    private Lobby lobby;

    public InvitePlayerDialog(Lobby lobby) {
        super();
        this.lobby=lobby;
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new GridLayout(3, 2));
        createWidgets();
        setVisible(true);
    }

    private void createWidgets() {
        add(new JLabel("    IP : "));
        add(createIpField());
        add(createButtonCancel());
        add(createButtonAccept());
    }

    private Component createButtonCancel() {
        JButton cancelButton = new JButton("CANCEL");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        return cancelButton;
    }

    private Component createButtonAccept() {
        JButton acceptButton = new JButton("OK");
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SendMessageCommand(new InvitePlayerMessage(new InvitePlayerData(ManagerLobby.myPlayer, ManagerLobby.myLobby)), new TCPSender(ipField.getText())).execute();
                setVisible(false);
            }
        });
        return acceptButton;
    }

    private Component createIpField() {
        ipField= new JTextField(MAX_COLUMNS);
        return ipField;
    }
}
