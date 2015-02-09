package model.message.impl;

import model.message.interfaces.Message;
import model.message.messagedata.impl.KickPlayerData;
import view.display.impl.swing.KickPlayerDisplay;

public class KickPlayerMessage implements Message {

    private KickPlayerData kickPlayerData;

    public KickPlayerMessage(KickPlayerData kickPlayerData) {
        this.kickPlayerData = kickPlayerData;
    }

    @Override
    public void open() {
        new KickPlayerDisplay();
    }
}
