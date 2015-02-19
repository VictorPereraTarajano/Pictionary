package model.statemessage.impl;

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
      /*  switch (sendTurnStateData.getTurnState()) {
            case Turn.RUNNING:
                break;
            case Turn.STOPPED:
                    new SendMessageCommand(new StartGameMessage(new StartGameData(new Turn (new Word("hola"),ManagerLobby.myPlayer))), ManagerConnection.TCPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers())).execute();
                break;
            default:
        }*/
    }
}
