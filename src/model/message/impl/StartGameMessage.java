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
        initGame();
        initCanvas();
        initChat();
        initWord();
        initTimer();
    }

    private void initGame() {
        ManagerLobby.myLobby.setGame(startGameData.getGame());
    }

    private void initCanvas() {
        ManagerLobby.myLobby.getCanvas().clear();
        ManagerLobby.myLobbyFrame.getCanvasPanel().refresh();
    }

    private void initChat() {
        ManagerLobby.myLobby.getChat().clear();
        ManagerLobby.myLobbyFrame.getChatPanel().refresh();
    }

    private void initWord() {
        ManagerLobby.myLobbyFrame.getWordPanel().getWordDisplay().clear();
        ManagerLobby.myLobbyFrame.getWordPanel().refresh();
    }

    private void initTimer(){
        if (!ManagerLobby.myLobby.host.equals(ManagerLobby.myPlayer))
        ManagerLobby.myLobby.getTimer().start();
    }
}
