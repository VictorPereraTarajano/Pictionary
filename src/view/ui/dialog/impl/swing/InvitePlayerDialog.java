package view.ui.dialog.impl.swing;

import controller.impl.sendcommand.SendMessageCommand;
import model.game.Lobby;
import model.manager.ManagerConnection;
import model.message.impl.InvitePlayerMessage;
import model.messagedata.impl.InvitePlayerData;
import model.net.sender.impl.TCPSender;
import model.manager.ManagerLobby;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class InvitePlayerDialog extends JDialog implements view.ui.dialog.interfaces.InvitePlayerDialog {

    private static final int WIDTH=300, HEIGHT=100;

    private JFormattedTextField ipField;

    public InvitePlayerDialog() {
        super();
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
        return new JButton("CANCEL") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                    }
                });
            }
        };
    }

    private Component createButtonAccept() {
        return new JButton("OK") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (ManagerConnection.isValidConnection(ipField.getText())) {
                            new SendMessageCommand(new InvitePlayerMessage(new InvitePlayerData(ManagerLobby.myPlayer, ManagerLobby.myLobby)), new TCPSender(ipField.getText())).execute();
                            setVisible(false);
                        } else
                            ipField.setText("");
                    }
                });
            }
        };
    }

    private Component createIpField() {
        try {
            ipField= new JFormattedTextField(new MaskFormatter("###.###.###.###"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ipField;
    }
}
