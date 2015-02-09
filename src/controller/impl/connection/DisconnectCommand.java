package controller.impl.connection;

import controller.interfaces.Command;
import model.net.receiver.interfaces.Receiver;

public class DisconnectCommand implements Command {

    private Receiver receiver;

    public DisconnectCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.stop();
    }
}
