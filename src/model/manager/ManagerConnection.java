package model.manager;

import model.network.receiver.interfaces.Receiver;
import model.network.sender.impl.TCPSender;
import model.network.sender.impl.UDPSender;
import model.network.sender.interfaces.Sender;
import model.player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ManagerConnection {

    public static final String DefaultIP= "213.231.107.155";

    public static final int UDPort = 2000;
    public static final int TCPort = 2000;
    public static Receiver UDPreceiver;
    public static Receiver TCPreceiver;

    private static String getDefaultIP() {
        try {
            URLConnection provider = new URL("http://api.ipify.org?format=json").openConnection();
            BufferedReader exchangeRateInfo = new BufferedReader(new InputStreamReader(provider.getInputStream()));
            String ip = exchangeRateInfo.readLine().split(":")[1];
            return ip.substring(1,ip.length()-2 );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getStatus () {
        if (UDPreceiver != null || TCPreceiver != null)
            return "CONNECTED";
        return "DISCONNECTED";
    }

    public static Sender []  TCPBroadcast () {
        return TCPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers());
    }

    public static Sender []  UDPBroadcast () {
        return UDPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers());
    }

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
