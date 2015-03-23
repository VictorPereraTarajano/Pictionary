package controller.impl.command.connection;

import controller.interfaces.Command;
import model.manager.ManagerConnection;
import model.network.receiver.impl.TCPReceiver;
import model.network.receiver.impl.UDPReceiver;

public class ConnectCommand implements Command {

    private void createUDPReceiver() {
        ManagerConnection.UDPreceiver =  new UDPReceiver();
        ManagerConnection.UDPreceiver.receive();
    }

    @Override
    public void execute() {
        if (ManagerConnection.getStatus().equals(ManagerConnection.DISCONNECTED)) createReceivers();
    }

    private void createReceivers() {
        createUDPReceiver();
        createTCPReceiver();
    }

    private void createTCPReceiver() {
        ManagerConnection.TCPreceiver =  new TCPReceiver();
        ManagerConnection.TCPreceiver.receive();
    }

}
