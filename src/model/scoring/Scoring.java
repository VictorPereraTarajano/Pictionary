package model.scoring;

import model.player.Player;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Scoring implements Serializable {

    private Map<Player, Score> scoring;

    public Scoring() {
        scoring = new HashMap<>();
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
}
