package controller.impl.sendcommand.message.impl;

import model.manager.ManagerLobby;
import controller.impl.sendcommand.message.interfaces.Message;
import controller.impl.sendcommand.messagedata.impl.HostMigrationData;

import java.io.Serializable;

public class HostMigrationMessage implements Message, Serializable {

    private HostMigrationData hostMigrationData;

    public HostMigrationMessage(HostMigrationData hostMigrationData) {
        this.hostMigrationData = hostMigrationData;
    }

    @Override
    public void open() {
        ManagerLobby.myLobby=hostMigrationData.getLobby();
        ManagerLobby.myLobby.getScoring().remove(hostMigrationData.getLobby().getHost());
        ManagerLobby.myLobby.setHost(hostMigrationData.getAnotherHost());
        ManagerLobby.myLobbyFrame.getScoringPanel().refresh();
    }
}
