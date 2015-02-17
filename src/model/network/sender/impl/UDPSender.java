package model.network.sender.impl;

import model.manager.ManagerConnection;
import model.message.interfaces.Message;
import model.network.sender.interfaces.Sender;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSender implements Sender, Runnable {

    private static final int MAX_SIZE_ARRAY=6400;

    private String IP;
    private DatagramSocket socket;
    private Thread thread;
    private Message message;

    public UDPSender(String IP) {
        this.IP = IP;
        thread=new Thread(this);
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
    public void send(Message objectToSend) {
        this.message=objectToSend;
        thread.start();
    }

    @Override
    public void run() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(MAX_SIZE_ARRAY);
            new ObjectOutputStream(baos).writeObject(message);
            socket.send(new DatagramPacket(baos.toByteArray(), baos.toByteArray().length, InetAddress.getByName(IP), ManagerConnection.UDPort));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
