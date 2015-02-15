package view.ui.display.impl.swing.kickplayerdisplay;

import model.messagedata.impl.KickPlayerData;

public class KickPlayerDisplay implements view.ui.display.interfaces.kickplayerdisplay.KickPlayerDisplay {

    private KickPlayerData kickPlayerData;

    public KickPlayerDisplay(KickPlayerData kickPlayerData) {
        this.kickPlayerData = kickPlayerData;
    }

    @Override
    public void display() {

    }
}
