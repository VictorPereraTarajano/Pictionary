package model.message.impl.state.impl;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import model.message.impl.state.interfaces.SendStateMessage;
import model.message.messagedata.impl.statedata.interfaces.SendStateData;

public class SendChatStateMessage extends SendStateMessage{

    public SendChatStateMessage(SendStateData sendStateData) {
        super(sendStateData);
    }

    @Override
    public void open() {

    }
}
