package receiver.impl;

import deserializer.impl.StateBuilder;
import gamestate.impl.bundle.BundleState;
import gamestate.interfaces.State;
import receiver.interfaces.Receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiver<T> implements Receiver<T>, Runnable {

    private Thread thread;
    private int myPort;
    private DatagramSocket socket;
    private byte [] receiveData;

    private static final int MAX_BUFFER_SIZE=2048;
    private boolean running = true;

    public UDPReceiver(int myPort) {
        this.myPort = myPort;
        receiveData = new byte[MAX_BUFFER_SIZE];
        createDatagramSocket();
        createThread();
    }

    private void createDatagramSocket() {
        try {
            socket = new DatagramSocket(myPort);
            socket.setReceiveBufferSize(MAX_BUFFER_SIZE);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public int getMyPort() {
        return myPort;
    }

    private void createThread() {
        thread = new Thread(this);
    }

    @Override
    public void receive() {
        thread.start();
    }

    @Override
    public void close() {
        running=false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                T bundle = new StateBuilder<T>().deserialize(receiveData, receivePacket.getLength());
                ((State)bundle).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
