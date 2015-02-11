package controller.impl.command.connection;

import controller.interfaces.Command;
import model.net.receiver.impl.TCPReceiver;
import model.net.receiver.impl.UDPReceiver;
import model.net.receiver.interfaces.Receiver;

public class ConnectCommand implements Command {

    private static final int myPort = 2000;

    public static Receiver receiver;

    @Override
    public void execute() {
        receiver =  new UDPReceiver(myPort);
        receiver.receive();
    }

}
