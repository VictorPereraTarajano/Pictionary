package model.statemessage.impl;

import model.manager.ManagerLobby;
import model.statemessage.interfaces.SendStateMessage;
import model.statemessagedata.impl.SendScoringStateData;
import view.ui.frame.impl.swing.LobbyFrame;

public class SendScoringStateMessage extends SendStateMessage {

    private SendScoringStateData sendScoringStateData;

    public SendScoringStateMessage(SendScoringStateData sendScoringStateData) {
        super();
        this.sendScoringStateData = sendScoringStateData;
    }

    @Override
    public void open() {
        if (ManagerLobby.myLobbyFrame==null) {
            ManagerLobby.myLobbyFrame= new LobbyFrame();
        }
        ManagerLobby.myLobby.setScoring(sendScoringStateData.getScoring());
        ManagerLobby.myLobbyFrame.getScoringPanel().refresh();
        ManagerLobby.myLobbyFrame.setVisible(true);
    }
}
