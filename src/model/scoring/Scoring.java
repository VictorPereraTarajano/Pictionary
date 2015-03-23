package model.scoring;

import model.manager.ManagerLobby;
import model.player.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Scoring implements Serializable {

    private Map<Player, Score> scoring = new LinkedHashMap();

    public Scoring() {
        add(ManagerLobby.myPlayer, new Score(0));
    }

    public void remove (Player player) {
        scoring.remove(player);
    }

    public int getPosition (Player playerE) {
        Player [] players = scoring.keySet().toArray(new Player [scoring.size()]);
        for (int i = 0; i < players.length; i++)
            if (players[i].equals(playerE)) return i+1;
        return 0;
    }

    public void add(Player player, Score score) {
        scoring.put(player,score);
    }

    public int size () {
        return scoring.size();
    }

    public Score getScore (Player player) {
        return scoring.get(player);
    }

    public Player [] getPlayers () {
        return scoring.keySet().toArray(new Player [scoring.size()]);
    }

    public Player[] getAllWithoutMe() {
        ArrayList<Player> playerWithoutMe = new ArrayList<>();
        for (Player player : getPlayers())
            if (!player.equals(ManagerLobby.myPlayer)) playerWithoutMe.add(player);
        return playerWithoutMe.toArray(new Player[playerWithoutMe.size()]);
    }
}
