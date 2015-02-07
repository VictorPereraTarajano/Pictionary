package sender.impl;

import sender.interfaces.Sender;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class UDPSender<T> implements Sender<T> {

    private static final int MAX_SIZE_ARRAY=6400;

    private int toPort;
    private String IP;
    private DatagramSocket socket;
    private InetAddress IPAddress;

    public UDPSender(int toPort, String IP) {
        this.toPort = toPort;
        this.IP = IP;
        createIPAddress();
        createDatagramSocket();
    }

    private void createIPAddress() {
        try {
            IPAddress = InetAddress.getByName(IP);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private void createDatagramSocket () {
        try {
            this.socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public DatagramSocket getSocket() {
        return socket;
    }

    public int getToPort() {
        return toPort;
    }

    public InetAddress getIPAddress() {
        return IPAddress;
    }

    @Override
    public void send(T objectToSend) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(MAX_SIZE_ARRAY);
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(objectToSend);
            byte [] data = baos.toByteArray();
            socket.send(new DatagramPacket(data,data.length,  IPAddress, toPort));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
