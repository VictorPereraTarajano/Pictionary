package model.message.impl;

import model.message.interfaces.Message;
import model.messagedata.impl.InvitePlayerData;
import view.ui.display.impl.swing.inviteplayerdisplay.InvitePlayerDisplay;

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
