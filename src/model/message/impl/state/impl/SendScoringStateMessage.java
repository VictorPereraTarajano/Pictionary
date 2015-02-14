package model.message.impl.state.impl;

import model.manager.ManagerLobby;
import model.message.impl.state.interfaces.SendStateMessage;
import model.messagedata.impl.statedata.impl.SendScoringStateData;

public class SendScoringStateMessage extends SendStateMessage {

    private SendScoringStateData sendScoringStateData;

    public SendScoringStateMessage(SendScoringStateData sendScoringStateData) {
        super();
        this.sendScoringStateData = sendScoringStateData;
    }

    @Override
    public void open() {
        ManagerLobby.myLobby.getPlayerSet().clear();
        ManagerLobby.myLobby.getPlayerSet().addAll(sendScoringStateData.getPlayers());
        ManagerLobby.myLobbyFrame.getScoringPanel().refresh();
    }
}
