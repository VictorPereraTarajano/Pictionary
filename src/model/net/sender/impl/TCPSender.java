package model.net.sender.impl;

import model.manager.ManagerConnection;
import model.net.sender.interfaces.Sender;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPSender<T> implements Sender<T> {

    private final String IP;
    private Socket socket;

    public TCPSender(String IP) {
        this.IP = IP;
        try {
            socket = new Socket(IP, ManagerConnection.TCPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(T objectToSend) {
        OutputStream os;
        try {
            os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(objectToSend);
            oos.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
