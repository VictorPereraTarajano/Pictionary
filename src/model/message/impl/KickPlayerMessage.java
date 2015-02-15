package model.message.impl;

import model.message.interfaces.Message;
import model.messagedata.impl.KickPlayerData;
import view.ui.display.impl.swing.kickplayerdisplay.KickPlayerDisplay;

import java.io.Serializable;

public class KickPlayerMessage implements Message, Serializable {

    private KickPlayerData kickPlayerData;

    public KickPlayerMessage(KickPlayerData kickPlayerData) {
        this.kickPlayerData = kickPlayerData;
    }

    @Override
    public void open() {
        new KickPlayerDisplay(kickPlayerData).display();
    }
}
