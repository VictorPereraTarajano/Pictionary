package model.message.impl;

import model.manager.ManagerLobby;
import model.message.interfaces.Message;
import model.messagedata.impl.HostMigrationData;

import java.io.Serializable;

public class HostMigrationMessage implements Message, Serializable {

    private HostMigrationData hostMigrationData;

    public HostMigrationMessage(HostMigrationData hostMigrationData) {
        this.hostMigrationData = hostMigrationData;
    }

    @Override
    public void open() {
            ManagerLobby.myLobby=hostMigrationData.getLobby();
            ManagerLobby.myLobby.host=hostMigrationData.getAnotherHost();
            ManagerLobby.myLobby.getScoring().remove(hostMigrationData.getLobby().host);
            ManagerLobby.myLobbyFrame.refresh();
    }
}
