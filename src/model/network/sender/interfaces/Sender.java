package model.network.sender.interfaces;

import controller.interfaces.Command;

public interface Sender {
    public void send (Command command);
}
