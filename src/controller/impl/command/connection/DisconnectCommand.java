package controller.impl.command.connection;

import controller.interfaces.Command;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;

public class DisconnectCommand implements Command {

    @Override
    public void execute() {
        ManagerConnection.UDPreceiver.stop();
        ManagerConnection.TCPreceiver.stop();
        ManagerConnection.UDPreceiver=null;
        ManagerConnection.TCPreceiver=null;
    }
}
