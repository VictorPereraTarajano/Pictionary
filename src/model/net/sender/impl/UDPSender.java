package model.net.sender.impl;

import model.net.manager.ManagerConnection;
import model.net.sender.interfaces.Sender;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class UDPSender<T> implements Sender<T> {

    private static final int MAX_SIZE_ARRAY=6400;

    private String IP;
    private DatagramSocket socket;

    public UDPSender(String IP) {
        this.IP = IP;
        createDatagramSocket();
    }

    private void createDatagramSocket ()  {
        try {
            this.socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(T objectToSend) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(MAX_SIZE_ARRAY);
            new ObjectOutputStream(baos).writeObject(objectToSend);
            socket.send(new DatagramPacket(baos.toByteArray(), baos.toByteArray().length, InetAddress.getByName(IP), ManagerConnection.UDPort));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
