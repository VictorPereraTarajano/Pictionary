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
        initCanvas();
        initChat();
        initWord();
        initTimer();
    }

    private void initCanvas() {
        ManagerLobby.myLobby.getCanvas().clear();
        if (!ManagerLobby.myPlayer.equals(startGameData.getTurn().getPlayer())) ManagerLobby.myLobby.getCanvas().lock();
        ManagerLobby.myLobbyFrame.getCanvasPanel().refresh();
    }

    private void initChat() {
        ManagerLobby.myLobby.getChat().clear();
        ManagerLobby.myLobbyFrame.getChatPanel().refresh();
    }

    private void initWord() {
        ManagerLobby.myLobbyFrame.getWordPanel().getWordDisplay().clear();
        ManagerLobby.myLobby.getGame().addTurn(startGameData.getTurn());
        ManagerLobby.myLobbyFrame.getWordPanel().refresh();
    }

    private void initTimer(){
        ManagerLobby.myLobby.getTimer().start();
    }
}
