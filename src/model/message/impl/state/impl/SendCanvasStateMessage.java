package model.message.impl.state.impl;

import model.manager.ManagerLobby;
import model.message.impl.state.interfaces.SendStateMessage;
import model.messagedata.impl.statedata.impl.SendCanvasStateData;

public class SendCanvasStateMessage extends SendStateMessage {

    private SendCanvasStateData sendCanvasStateData;

    public SendCanvasStateMessage(SendCanvasStateData sendCanvasStateData) {
        super();
        this.sendCanvasStateData=sendCanvasStateData;
    }

    @Override
    public void open() {
        if (sendCanvasStateData.isCleared())
            ManagerLobby.myLobby.getCanvas().clear();
        else
            ManagerLobby.myLobby.getCanvas().add(sendCanvasStateData.getPoint());
        ManagerLobby.myLobbyFrame.getCanvasPanel().refresh();
    }
}
