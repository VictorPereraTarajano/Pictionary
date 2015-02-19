package model.statemessage.impl;

import model.manager.ManagerLobby;
import model.message.interfaces.Message;
import model.statemessagedata.impl.SendTurnStateData;

import java.io.Serializable;

public class SendTurnStateMessage implements Message,Serializable {

    private SendTurnStateData sendTurnStateData;

    public SendTurnStateMessage(SendTurnStateData sendFinishTurnData) {
        super();
        this.sendTurnStateData=sendFinishTurnData;
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
        if (ManagerLobby.myLobby.host.equals(ManagerLobby.myPlayer))
            ManagerLobby.myLobby.getTimer().start();
    }
}
