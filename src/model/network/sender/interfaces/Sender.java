package model.network.sender.interfaces;

import model.message.interfaces.Message;

public interface Sender {
    public void send (Message objectToSend);
}
