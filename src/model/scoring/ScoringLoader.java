package model.scoring;

import model.player.Player;
import model.playerset.interfaces.PlayerSet;

public class ScoringLoader {
    public Scoring load(PlayerSet playerSet){
        Scoring scoring=new Scoring();
        for (Player player : playerSet.toArray())
            scoring.add(player, new Score(0));
        return scoring;
    }
}
