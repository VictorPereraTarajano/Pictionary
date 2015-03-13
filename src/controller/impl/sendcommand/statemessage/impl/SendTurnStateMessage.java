package controller.impl.sendcommand.statemessage.impl;

import model.game.Game;
import model.manager.ManagerGame;
import model.manager.ManagerLobby;
import controller.impl.sendcommand.message.interfaces.Message;
import controller.impl.sendcommand.statemessagedata.impl.SendTurnStateData;

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
        sleep(500);
        initTurn();
        ManagerLobby.myLobbyFrame.getLogLabel().setText("Clearing Canvas ...");
        sleep(500);
        //initCanvas();
        ManagerLobby.myLobbyFrame.getLogLabel().setText("Clearing Chat ...");
        sleep(500);
        initChat();
        ManagerLobby.myLobbyFrame.getLogLabel().setText("Changing Word  ...");
        sleep(500);
        initWord();
        ManagerLobby.myLobbyFrame.getLogLabel().setText("The turn begin in ...");
        sleep(500);
        //ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().drawString("3");
        sleep(1000);
        clearCanvas();
        //ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().drawString("2");
        sleep(1000);
        clearCanvas();
        //ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().drawString("1");
        sleep(1000);
        clearCanvas();
        ManagerLobby.myLobbyFrame.getLogLabel().setText("GOOD LUCK");
        sleep(500);
        ManagerLobby.myLobbyFrame.getLogLabel().setText("Connected");
        initTimer();
    }

    private void sleep (int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initTurn() {
        if (ManagerLobby.myLobby.getGame() == null) ManagerLobby.myLobby.setGame(new Game());
        ManagerLobby.myLobby.getGame().addTurn(sendTurnStateData.getTurn());
    }

    private void clearCanvas () {
        ManagerLobby.myLobby.getCanvas().clear();
        ManagerLobby.myLobbyFrame.getCanvasPanel().refresh();
    }

    private void initCanvas() {
        if (!ManagerGame.isPainter(ManagerLobby.myPlayer))
            ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().setEditable(false);
        else
            ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().setEditable(true);
        clearCanvas();
    }

    private void initChat() {
        ManagerLobby.myLobby.getChat().clear();
        if (!ManagerGame.isPainter(ManagerLobby.myPlayer))
            ManagerLobby.myLobbyFrame.getChatPanel().getChatDialog().setEditable(true);
        else
            ManagerLobby.myLobbyFrame.getChatPanel().getChatDialog().setEditable(false);
        ManagerLobby.myLobbyFrame.getChatPanel().clear();
    }

    private void initWord() {
        ManagerLobby.myLobbyFrame.getWordPanel().getWordDisplay().clear();
        if (!ManagerGame.isPainter(ManagerLobby.myPlayer))
            ManagerLobby.myLobbyFrame.getWordPanel().getWordDisplay().setVisible(false);
        else
            ManagerLobby.myLobbyFrame.getWordPanel().getWordDisplay().setVisible(true);
        ManagerLobby.myLobbyFrame.getWordPanel().refresh();
    }

    private void initTimer(){
        if (ManagerLobby.myLobby.host.equals(ManagerLobby.myPlayer))
            ManagerLobby.myLobby.getTimer().start();
    }
}
