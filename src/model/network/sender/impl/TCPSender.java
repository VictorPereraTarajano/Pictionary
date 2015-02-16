package model.network.sender.impl;

import model.manager.ManagerConnection;
import model.network.sender.interfaces.Sender;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPSender<T> implements Sender<T> {

    private Socket socket;

    public TCPSender(String IP) {
        createSocket(IP);
    }

    private void createSocket(String IP) {
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
            if (socket==null) return;
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