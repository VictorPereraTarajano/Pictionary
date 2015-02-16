package model.message.impl.state.impl;

import model.manager.ManagerLobby;
import model.message.impl.state.interfaces.SendStateMessage;
import model.messagedata.impl.statedata.impl.SendLobbyStateData;
import view.ui.frame.impl.swing.LobbyFrame;

public class SendLobbyStateMessage extends SendStateMessage{

    private SendLobbyStateData sendLobbyStateData;

    public SendLobbyStateMessage(SendLobbyStateData sendLobbyStateData) {
        super();
        this.sendLobbyStateData = sendLobbyStateData;
    }

    @Override
    public void open() {
        ManagerLobby.myLobby=sendLobbyStateData.getLobby();
        if (ManagerLobby.myLobbyFrame==null)
            ManagerLobby.myLobbyFrame= new LobbyFrame(sendLobbyStateData.getLobby());
        else
            ManagerLobby.myLobbyFrame.refresh();
        ManagerLobby.myLobbyFrame.setVisible(true);
    }
}
