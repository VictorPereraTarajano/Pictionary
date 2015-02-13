package model.net.manager;

import model.net.receiver.interfaces.Receiver;
import model.net.sender.impl.TCPSender;
import model.net.sender.impl.UDPSender;
import model.net.sender.interfaces.Sender;
import model.player.Player;

import java.net.InetAddress;

public class ManagerConnection {

    public static final String DefaultIP="192.168.1.13";
    public static final int UDPort = 2000;
    public static final int TCPort = 2000;
    public static Receiver UDPreceiver;
    public static Receiver TCPreceiver;

    public static Sender []  TCPBroadcast (Player[] players) {
        Sender[] senders = new Sender[players.length];
        for (int i = 0; i < senders.length; i++)
            senders[i] = new TCPSender(players[i].getIp());
        return senders;
    }

    public static Sender []  UDPBroadcast (Player[] players) {
        Sender[] senders = new Sender[players.length];
        for (int i = 0; i < senders.length; i++)
            senders[i] = new UDPSender(players[i].getIp());
        return senders;
    }
}
