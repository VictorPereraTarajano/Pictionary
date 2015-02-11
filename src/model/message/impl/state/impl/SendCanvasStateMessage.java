package model.message.impl.state.impl;

import model.game.Lobby;
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
        LobbyFrame.getCanvasPanel().display(sendCanvasStateData);
    }
}
