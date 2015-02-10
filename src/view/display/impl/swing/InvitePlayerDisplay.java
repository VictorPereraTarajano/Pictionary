package view.display.impl.swing;

import controller.impl.send.SendMessageCommand;
import model.message.impl.ConfirmationMessage;
import model.message.messagedata.impl.InvitePlayerData;
import model.net.sender.impl.UDPSender;
import view.frame.impl.swing.LobbyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvitePlayerDisplay extends JDialog implements view.display.interfaces.InvitePlayerDisplay {

    private JLabel messageInvitation;
    private InvitePlayerData invitePlayerData;
    private JButton acceptButton, cancelButton;

    public InvitePlayerDisplay(InvitePlayerData invitePlayerData) {
        super();
        this.invitePlayerData = invitePlayerData;
        setLayout(new GridLayout(0,2));
        createWidgets();
        setVisible(true);
    }

    private void createWidgets() {
        messageInvitation=new JLabel();
        add(createMessageInvitation());
        add(createAcceptButton());
        add(createCancelButton());
    }

    private Component createMessageInvitation() {
        messageInvitation=new JLabel();
        return messageInvitation;
    }

    private Component createCancelButton() {
        cancelButton = new JButton("CANCEL");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        return cancelButton;
    }

    private Component createAcceptButton() {
        acceptButton = new JButton("OK");
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SendMessageCommand(new ConfirmationMessage(), new UDPSender(2000,invitePlayerData.getPlayer().getIp())).execute();
                new LobbyFrame(invitePlayerData.getLobby());
                setVisible(false);
            }
        });
        return acceptButton;
    }

    @Override
    public void display() {
        messageInvitation.setText("You have been invited by "+invitePlayerData.getPlayer().getName()+" to a new lobby");
    }
}
