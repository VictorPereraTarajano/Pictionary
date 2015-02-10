package view.display.impl.swing;

import model.message.messagedata.impl.KickPlayerData;

public class KickPlayerDisplay implements view.display.interfaces.KickPlayerDisplay {

    private KickPlayerData kickPlayerData;

    public KickPlayerDisplay(KickPlayerData kickPlayerData) {
        this.kickPlayerData = kickPlayerData;
    }

    @Override
    public void display() {

    }
}
