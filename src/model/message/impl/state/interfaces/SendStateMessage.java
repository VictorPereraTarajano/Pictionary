package model.message.impl.state.interfaces;

import model.message.interfaces.Message;
import model.message.messagedata.impl.statedata.interfaces.SendStateData;
import view.frame.impl.swing.LobbyFrame;

import java.io.Serializable;

public abstract class SendStateMessage implements Message, Serializable {

    public static LobbyFrame LobbyFrame;

}
