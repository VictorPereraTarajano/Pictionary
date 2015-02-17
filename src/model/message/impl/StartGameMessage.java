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
        refreshCanvas();
        refreshChat();
        refreshWord();
        refreshTimer();
    }

    private void refreshCanvas() {
        ManagerLobby.myLobby.getCanvas().clear();
        ManagerLobby.myLobbyFrame.getCanvasPanel().refresh();
    }

    private void refreshChat () {
        ManagerLobby.myLobby.getChat().clear();
        ManagerLobby.myLobbyFrame.getChatPanel().refresh();
    }

    private void refreshWord() {
        ManagerLobby.myLobbyFrame.getWordPanel().refresh();
    }

    private void refreshTimer ( ){
        ManagerLobby.myLobby.getTimer().start();
    }
}
