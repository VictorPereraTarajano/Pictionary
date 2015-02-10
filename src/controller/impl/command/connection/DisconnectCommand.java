package controller.impl.command.connection;

import controller.interfaces.Command;
import model.net.receiver.interfaces.Receiver;

public class DisconnectCommand implements Command {

    @Override
    public void execute() {
        ConnectCommand.receiver.stop();
    }
}
