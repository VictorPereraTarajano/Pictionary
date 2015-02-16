package view.ui.display.impl.swing.inviteplayerdisplay;

import controller.impl.sendcommand.SendMessageCommand;
import model.message.impl.ConfirmationMessage;
import model.messagedata.impl.ConfirmationData;
import model.messagedata.impl.InvitePlayerData;
import model.network.sender.impl.TCPSender;
import model.manager.ManagerLobby;
import view.ui.frame.impl.swing.LobbyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvitePlayerDisplay extends JDialog implements view.ui.display.interfaces.inviteplayerdisplay.InvitePlayerDisplay {

    private JLabel messageInvitation;
    private InvitePlayerData invitePlayerData;

    public InvitePlayerDisplay(InvitePlayerData invitePlayerData) {
        super();
        this.invitePlayerData=invitePlayerData;
        setLayout(new GridLayout(0,2));
        createWidgets();
        setVisible(true);
    }

    private void createWidgets() {
        add(createMessageInvitation());
        add(createAcceptButton());
        add(createCancelButton());
    }

    private Component createMessageInvitation() {
        messageInvitation=new JLabel();
        return messageInvitation;
    }

    private Component createCancelButton() {
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

    private Component createAcceptButton() {
        return new JButton("OK"){
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ManagerLobby.myLobby=invitePlayerData.getLobby();
                        ManagerLobby.myLobbyFrame=new LobbyFrame(invitePlayerData.getLobby());
                        ManagerLobby.host =invitePlayerData.getPlayer();
                        ManagerLobby.myLobbyFrame.setVisible(false);
                        new SendMessageCommand(new ConfirmationMessage(new ConfirmationData(ManagerLobby.myPlayer)), new TCPSender(invitePlayerData.getPlayer().getIp())).execute();
                        setVisible(false);
                    }
                });
            }
        };
    }

    @Override
    public void display() {
        messageInvitation.setText("You have been invited by "+invitePlayerData.getPlayer().getName()+" to a new lobby");
    }
}
