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

    public static final String DefaultIP= "192.168.1.15";

    public static final int UDPort = 2000;
    public static final int TCPort = 2000;
    public static Receiver UDPreceiver;
    public static Receiver TCPreceiver;

    private static String getDefaultIP() {
        try {
            BufferedReader exchangeRateInfo = new BufferedReader(new InputStreamReader(new URL("http://api.ipify.org?format=json").openConnection().getInputStream()));
            return exchangeRateInfo.readLine().split(":")[1].substring(1,exchangeRateInfo.readLine().split(":")[1].length()-2 );
        } catch (IOException e) {
            throw new IllegalArgumentException("No se ha podido obtener su IP pública");
        }
        return null;
    }

    public static String getStatus () {
        if (UDPreceiver != null || TCPreceiver != null)
            return "CONNECTED";
        return "DISCONNECTED";
    }

    public static Sender []  TCPBroadcastAll () {
        return TCPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers());
    }

    public static Sender []  UDPBroadcastAll () {
        return UDPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers());
    }

    public static Sender []  TCPBroadcast () {
        return TCPBroadcast(ManagerLobby.myLobby.getScoring().getAllWithoutMe());
    }

    public static Sender []  UDPBroadcast () {
        return UDPBroadcast(ManagerLobby.myLobby.getScoring().getAllWithoutMe());
    }

    public static Sender []  TCPBroadcast (Player[] players) {
        return createSenders("TCPSender", players);
    }

    public static Sender []  UDPBroadcast (Player[] players) {
        return createSenders("UDPSender", players);
    }
    
    private Sender [] createSenders (String typeSender, Player [] players) {
        Sender[] senders = new Sender[players.length];
        for (int i = 0; i < senders.length; i++)
            senders[i] = Class.forName(typeSender).getConstructors(Class.String).newInstance(players[i].getIp());
        return senders;
    }

}
