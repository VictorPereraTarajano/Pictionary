package model.game;

import model.player.Player;
import model.word.Word;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Turn implements Serializable {

    private Word word;
    private Player player;
    private Map<Player, Boolean> playerMap;

    public Turn(Word word, Player player, Player [] nonPainterPlayers) {
        this.word = word;
        convertToMap(nonPainterPlayers);
        this.player = player;
    }

    private void convertToMap(Player[] nonPainterPlayers) {
        playerMap = new HashMap<>();
        for (Player player : nonPainterPlayers)
            playerMap.put(player, false);
    }

    public void setAsserted (Player player) {
        playerMap.put(player, true);
    }

    public boolean hasAsserted (Player player) {
        return playerMap.get(player);
    }

    public boolean isFinished (){
        for (Player player : playerMap.keySet())
            if (!playerMap.get(player)) return false;
        return true;
    }


    public Player [] getNonPainterPlayers () {
        return playerMap.keySet().toArray(new Player [playerMap.size()]);
    }

    public Word getWord() {
        return word;
    }

    public Player getPlayer() {
        return player;
    }

}
