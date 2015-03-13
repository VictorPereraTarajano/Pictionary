package controller.impl.sendcommand.message.impl;

import controller.impl.sendcommand.message.interfaces.Message;
import controller.impl.sendcommand.messagedata.impl.InvitePlayerData;
import view.ui.display.impl.swing.InvitePlayerDisplay;

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
