package model.scoring;

import model.manager.ManagerLobby;
import model.player.Player;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Scoring implements Serializable {

    private Map<Player, Score> scoring;

    public Scoring() {
        scoring = new LinkedHashMap<>();
        add(ManagerLobby.myPlayer,new Score(0));
    }

    public void remove (Player player) {
        scoring.remove(player);
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
        Player [] players = getPlayers();
        Player [] playersWithoutMe = new Player [players.length-1];
        for (int i = 0; i < scoring.size(); i++) {
            if (players[i].equals(ManagerLobby.myPlayer)) {
                i--;
                continue;
            }
            playersWithoutMe[i]=players[i];
        }
        return playersWithoutMe;
    }
}
