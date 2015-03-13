package model.network.sender.impl;

import controller.interfaces.Command;
import model.manager.ManagerConnection;
import model.network.sender.interfaces.Sender;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSender implements Sender, Runnable {

    private static final int MAX_SIZE_ARRAY=2000;

    private String IP;
    private DatagramSocket socket;
    private Thread thread;
    private Command command;

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
    public void send(Command command) {
        this.command= command;

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(MAX_SIZE_ARRAY);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(baos);
            objectOutputStream.writeObject(command);
            objectOutputStream.flush();
            objectOutputStream.close();
            DatagramPacket datagramPacket = new DatagramPacket(baos.toByteArray(), baos.toByteArray().length, InetAddress.getByName(IP), ManagerConnection.UDPort);
            socket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(MAX_SIZE_ARRAY);
            new ObjectOutputStream(baos).writeObject(command);
            socket.send(new DatagramPacket(baos.toByteArray(), baos.toByteArray().length, InetAddress.getByName(IP), ManagerConnection.UDPort));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
