package model.statemessage.impl;

import controller.impl.sendcommand.SendMessageCommand;
import model.game.Turn;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.message.impl.StartGameMessage;
import model.message.interfaces.Message;
import model.messagedata.impl.StartGameData;
import model.statemessagedata.impl.SendTurnStateData;
import model.word.Word;

import java.io.Serializable;

public class SendTurnStateMessage implements Message,Serializable {

    private SendTurnStateData sendTurnStateData;

    public SendTurnStateMessage(SendTurnStateData sendFinishTurnData) {
        super();
        this.sendTurnStateData=sendFinishTurnData;
    }

    @Override
    public void open() {
        switch (sendTurnStateData.getTurnState()) {
            case Turn.RUNNING:
                break;
            case Turn.STOPPED:
                    new SendMessageCommand(new StartGameMessage(new StartGameData(new Turn (new Word("hola"),ManagerLobby.myPlayer))), ManagerConnection.TCPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers())).execute();
                break;
            default:
        }
    }
}
