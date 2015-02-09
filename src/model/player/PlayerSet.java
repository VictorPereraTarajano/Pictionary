package model.player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayerSet implements Serializable{

    List<Player> playerList;
    
    public PlayerSet () {
        playerList = new ArrayList<>();
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void add (Player player) {
        playerList.add(player);
    }

    public Player get (int i) {
        return playerList.get(i);
    }

    public void remove (Player player) {
        playerList.remove(player);
    }
}
