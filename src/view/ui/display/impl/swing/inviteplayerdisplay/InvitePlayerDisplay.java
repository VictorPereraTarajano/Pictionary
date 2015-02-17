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

    private static final int WIDTH=200, HEIGHT=200;
    private static InvitePlayerDisplay mySelf;

    private JLabel messageInvitation;
    private InvitePlayerData invitePlayerData;

    public InvitePlayerDisplay(InvitePlayerData invitePlayerData) {
        super();
        mySelf=this;
        this.invitePlayerData=invitePlayerData;
        setLayout(new GridLayout(0,2));
        setLocation(500,500);
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
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
                        ManagerLobby.myLobbyFrame=new LobbyFrame();
                        ManagerLobby.myLobby.host =invitePlayerData.getPlayer();
                        new SendMessageCommand(new ConfirmationMessage(new ConfirmationData(ManagerLobby.myPlayer)), new TCPSender(invitePlayerData.getPlayer().getIp())).execute();
                        mySelf.setVisible(false);
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
