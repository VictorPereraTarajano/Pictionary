package model.message.impl.state.impl;

import model.message.impl.state.interfaces.SendStateMessage;
import model.messagedata.impl.statedata.impl.SendCanvasStateData;
import model.manager.ManagerLobby;

public class SendCanvasStateMessage extends SendStateMessage {

    private SendCanvasStateData sendCanvasStateData;

    public SendCanvasStateMessage(SendCanvasStateData sendCanvasStateData) {
        super();
        this.sendCanvasStateData=sendCanvasStateData;
    }

    @Override
    public void open() {
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().display(sendCanvasStateData);
    }
}
