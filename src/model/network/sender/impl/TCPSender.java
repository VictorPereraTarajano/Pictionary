package model.network.sender.impl;

import controller.interfaces.Command;
import model.manager.ManagerConnection;
import model.network.sender.interfaces.Sender;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPSender implements Sender, Runnable  {

    private Socket socket;
    private Thread thread;
    private Command command;

    public TCPSender(String IP) {
        createSocket(IP);
        thread = new Thread(this);
    }

    private void createSocket(String IP) {
        try {
            socket = new Socket(IP, ManagerConnection.TCPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(Command command) {
        this.command = command;
        thread.start();
    }

    @Override
    public void run() {
        OutputStream os;
        try {
            if (socket==null) return;
            os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(command);
            oos.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
