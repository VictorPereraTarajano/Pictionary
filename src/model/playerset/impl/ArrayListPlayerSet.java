package model.playerset.impl;

import model.player.Player;
import model.manager.ManagerLobby;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ArrayListPlayerSet implements model.playerset.interfaces.PlayerSet, Serializable{

    private List<Player> playerList;
    
    public ArrayListPlayerSet() {
        playerList = new ArrayList<>();
        add(ManagerLobby.myPlayer);
    }

    @Override
    public void add (Player player) {
        playerList.add(player);
    }

    @Override
    public void addAll(Player[] players) {
        for (Player player : players) {
            playerList.add(player);
        }
    }

    @Override
    public Player get (int i) {
        return playerList.get(i);
    }

    @Override
    public void remove (Player player) {
        playerList.remove(player);
    }

    @Override
    public Player [] toArray (){
        return playerList.toArray(new Player [playerList.size()]);
    }

    @Override
    public int length() {
        return playerList.size();
    }

    @Override
    public void clear() {
        playerList.clear();
    }
}
