package model.message.impl;

import model.manager.ManagerLobby;
import model.message.interfaces.Message;
import model.messagedata.impl.StartGameData;

import java.io.Serializable;

public class StartGameMessage implements Message, Serializable {

    private StartGameData startGameData;

    public StartGameMessage(StartGameData startGameData) {
        this.startGameData = startGameData;
    }

    @Override
    public void open() {
        ManagerLobby.myLobby.getChat().clear();
        ManagerLobby.myLobbyFrame.getChatPanel().refresh();
        ManagerLobby.myLobby.getCanvas().clear();
        ManagerLobby.myLobbyFrame.getCanvasPanel().refresh();
        ManagerLobby.myLobby.getTimer().setCount(0);
        ManagerLobby.myLobbyFrame.getTimerPanel().refresh();
    }
}
