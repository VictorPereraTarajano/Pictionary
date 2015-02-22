package model.statemessage.impl;

import model.game.Game;
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
        ManagerLobby.myLobbyFrame.getLogLabel().setText("Initializing new turn ...");
        sleep();
        initTurn();
        ManagerLobby.myLobbyFrame.getLogLabel().setText("Clearing Canvas ...");
        sleep();
        initCanvas();
        ManagerLobby.myLobbyFrame.getLogLabel().setText("Clearing Chat ...");
        sleep();
        initChat();
        ManagerLobby.myLobbyFrame.getLogLabel().setText("Changing Word  ...");
        sleep();
        initWord();
        ManagerLobby.myLobbyFrame.getLogLabel().setText("The turn begin in ...");
        sleep();
        ManagerLobby.myLobbyFrame.getLogLabel().setText("3 ...");
        sleep();
        ManagerLobby.myLobbyFrame.getLogLabel().setText("2 ...");
        sleep();
        ManagerLobby.myLobbyFrame.getLogLabel().setText("1 ...");
        sleep();
        ManagerLobby.myLobbyFrame.getLogLabel().setText("GOOD LUCK");
        sleep();
        ManagerLobby.myLobbyFrame.getLogLabel().setText("");
        initTimer();
    }

    private void sleep () {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initTurn() {
        if (ManagerLobby.myLobby.getGame() == null) ManagerLobby.myLobby.setGame(new Game());
        ManagerLobby.myLobby.getGame().addTurn(sendTurnStateData.getTurn());
    }

    private void initCanvas() {
        ManagerLobby.myLobby.getCanvas().clear();
        if (!ManagerLobby.myLobby.getGame().currentTurn().getPlayer().equals(ManagerLobby.myPlayer))
            ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().unlock();
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().lock();
        ManagerLobby.myLobbyFrame.getCanvasPanel().refresh();
    }

    private void initChat() {
        ManagerLobby.myLobby.getChat().clear();
        if (!ManagerLobby.myLobby.getGame().currentTurn().getPlayer().equals(ManagerLobby.myPlayer))
            ManagerLobby.myLobbyFrame.getChatPanel().getChatDialog().unlock();
        else
            ManagerLobby.myLobbyFrame.getChatPanel().getChatDialog().lock();
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
