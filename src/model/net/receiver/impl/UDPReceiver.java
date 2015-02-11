package model.net.receiver.impl;

import model.deserializer.impl.Deserializer;
import model.net.receiver.interfaces.Receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiver implements Receiver, Runnable {

    private static final int MAX_BUFFER_SIZE=2048;

    private Thread thread;
    private int myPort;
    private DatagramSocket socket;
    private byte [] receiveData;
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

    private void createThread() {
        thread = new Thread(this);
    }

    @Override
    public void receive() {
        thread.start();
    }

    @Override
    public void stop() {
        socket.close();
        running=false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                new Deserializer().deserialize(receiveData, receivePacket.getLength()).open();
            } catch (IOException e) {
            }
        }
    }
}
