package model.network.receiver.impl;

import controller.interfaces.Command;
import model.manager.ManagerConnection;
import model.network.receiver.interfaces.Receiver;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPReceiver implements Receiver, Runnable {

    private ServerSocket serverSocket;
    private Thread thread;
    private boolean running=true;

    public TCPReceiver() {
        createServerSocket();
        createThread();
    }

    private void createServerSocket() {
        try {
            this.serverSocket = new ServerSocket(ManagerConnection.TCPort);
        } catch (IOException e) {
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
        running=false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(running) {
            try {
                Socket socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                Command to = (Command) ois.readObject();
                is.close();
                socket.close();
                to.execute();
            } catch (IOException | ClassNotFoundException e) {
            }
        }
    }
}
