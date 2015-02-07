import gamestate.impl.chat.ChatState;
import gamestate.impl.bundle.BundleState;
import receiver.impl.UDPReceiver;
import receiver.interfaces.Receiver;
import sender.impl.UDPSender;
import sender.interfaces.Sender;

public class UDPTest {

    @org.junit.Test
    public void testSenderAndReceiverLocalhost() throws Exception {
        Receiver receiver = new UDPReceiver(2000);
        receiver.receive();
        Sender<BundleState> sender = new UDPSender<BundleState>(2000, "localhost");
        sender.send(new BundleState());
    }

}
