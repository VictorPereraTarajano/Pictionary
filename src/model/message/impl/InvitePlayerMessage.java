package model.message.impl;

import model.message.interfaces.Message;
import model.message.messagedata.impl.InvitePlayerData;
import view.display.impl.swing.InvitePlayerDisplay;

import java.io.Serializable;

public class InvitePlayerMessage implements Message, Serializable {

    private InvitePlayerData invitePlayerData;

    public InvitePlayerMessage(InvitePlayerData invitePlayerData) {
        this.invitePlayerData = invitePlayerData;
    }

    @Override
    public void open() {
        new InvitePlayerDisplay(invitePlayerData).display();
    }
}
