package controller.impl.command.connection;

import controller.interfaces.Command;
import model.manager.ManagerConnection;

public class DisconnectCommand implements Command {

    @Override
    public void execute() {
        ManagerConnection.UDPreceiver.stop();
        ManagerConnection.TCPreceiver.stop();
    }
}
