package controller.impl.connection;

import controller.interfaces.Command;
import model.net.receiver.impl.UDPReceiver;
import model.net.receiver.interfaces.Receiver;

public class ConnectCommand implements Command {

    private static final int myPort = 2000;

    private Receiver receiver;

    @Override
    public void execute() {
        receiver = new UDPReceiver(myPort);
        receiver.receive();
    }

    public static int getMyPort() {
        return myPort;
    }

    public Receiver getReceiver() {
        return receiver;
    }

}
