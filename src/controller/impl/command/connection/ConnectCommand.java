package controller.impl.command.connection;

import controller.interfaces.Command;
import model.net.manager.ManagerConnection;
import model.net.receiver.impl.TCPReceiver;
import model.net.receiver.impl.UDPReceiver;
import model.net.receiver.interfaces.Receiver;

public class ConnectCommand implements Command {

    @Override
    public void execute() {
        createUDPReceiver();
        createTCPReceiver();
    }

    private void createUDPReceiver() {
        ManagerConnection.UDPreceiver =  new UDPReceiver();
        ManagerConnection.UDPreceiver.receive();
    }

    private void createTCPReceiver() {
        ManagerConnection.TCPreceiver =  new TCPReceiver();
        ManagerConnection.TCPreceiver.receive();
    }

}
