package app;

import gamestate.impl.BundleState;
import gamestate.impl.bundle.BundleState;
import sender.impl.UDPSender;
import sender.interfaces.Sender;

public class App {

    public static void main(String[] args) {
        //Receiver receiver = new UDPReceiver(2000);
        //receiver.receive();
        Sender<BundleState> sender = new UDPSender<BundleState>(2000, "192.168.1.11");
        sender.send(new BundleState());
    }
}
