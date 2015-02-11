package model.net.receiver.impl;

import model.deserializer.impl.Deserializer;
import model.net.receiver.interfaces.Receiver;
import model.net.sender.interfaces.Sender;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPReceiver implements Receiver, Runnable {

    private static final int MAX_BUFFER_SIZE=2048;

    private ServerSocket serverSocket;
    private int myPort;
    private Thread thread;
    private boolean running=true;
    private byte [] receivedData;

    public TCPReceiver(int myPort) {
        this.myPort = myPort;
        receivedData = new byte[MAX_BUFFER_SIZE];
        createServerSocket();
        createThread();
    }

    private void createServerSocket() {
        try {
            this.serverSocket = new ServerSocket(myPort);
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
                Socket connectionSocket = serverSocket.accept();
                DataInputStream is = new DataInputStream(connectionSocket.getInputStream());
                is.readFully(receivedData);
                new Deserializer().deserialize(receivedData, receivedData.length).open();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
