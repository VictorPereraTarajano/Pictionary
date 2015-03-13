package controller.impl.sendcommand.message.impl;

import model.manager.ManagerLobby;
import controller.impl.sendcommand.message.interfaces.Message;
import controller.impl.sendcommand.messagedata.impl.KickPlayerData;
import view.ui.display.impl.swing.KickPlayerDisplay;

import java.io.Serializable;

public class KickPlayerMessage implements Message, Serializable {

    private KickPlayerData kickPlayerData;

    public KickPlayerMessage(KickPlayerData kickPlayerData) {
        this.kickPlayerData = kickPlayerData;
    }

    @Override
    public void open() {
        if (ManagerLobby.myPlayer.equals(kickPlayerData.getPlayer())) new KickPlayerDisplay(kickPlayerData).display();
    }
}
