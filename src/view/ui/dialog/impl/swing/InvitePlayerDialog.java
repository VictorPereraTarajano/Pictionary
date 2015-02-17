package view.ui.dialog.impl.swing;

import controller.impl.sendcommand.SendMessageCommand;
import model.manager.ManagerLobby;
import model.message.impl.InvitePlayerMessage;
import model.messagedata.impl.InvitePlayerData;
import model.network.sender.impl.TCPSender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvitePlayerDialog extends JDialog implements view.ui.dialog.interfaces.InvitePlayerDialog {

    private static final int WIDTH=300, HEIGHT=100;
    private JTextField ipField;
    private InvitePlayerDialog mySelf;

    public InvitePlayerDialog() {
        super();
        mySelf=this;
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new GridLayout(2, 2));
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
                        new SendMessageCommand(new InvitePlayerMessage(new InvitePlayerData(ManagerLobby.myPlayer, ManagerLobby.myLobby)), new TCPSender(ipField.getText())).execute();
                        mySelf.setVisible(false);
                    }
                });
            }
        };
    }

    private Component createIpField() {
        ipField= new JTextField(20);
        return ipField;
    }
}
