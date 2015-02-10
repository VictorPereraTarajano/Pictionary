package model.message.impl.state.interfaces;

import model.message.interfaces.Message;
import view.ui.frame.impl.swing.LobbyFrame;

import java.io.Serializable;

public abstract class SendStateMessage implements Message, Serializable {

    public static LobbyFrame LobbyFrame;

}
