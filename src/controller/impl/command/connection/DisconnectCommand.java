package controller.impl.command.connection;

import controller.interfaces.Command;
import model.manager.ManagerConnection;

public class DisconnectCommand implements Command {

    @Override
    public void execute() {
        if (ManagerConnection.getStatus().equals(ManagerConnection.CONNECTED)) stopReceivers();

    }

    private void stopReceivers () {
        ManagerConnection.UDPreceiver.stop();
        ManagerConnection.TCPreceiver.stop();
        ManagerConnection.UDPreceiver=null;
        ManagerConnection.TCPreceiver=null;
    }
}
