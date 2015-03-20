package model.manager;

import model.player.Player;

import java.awt.*;

public class ManagerGame {
    public static final int MIN_NUM_PLAYERS=1;
    public static final int NUM_MAX_TURNS=10;
    public static Color [] colorSet = new Color [] {Color.BLUE, Color.cyan,Color.RED, Color.YELLOW, Color.GREEN, Color.ORANGE};

    public static Color getAvailableColor () {
        for (Color color : colorSet) 
            if (isColorAvailable(color)) return color;
        return null;
    }

    public static boolean isColorAvailable (Color color) {
        for (Player player : ManagerLobby.myLobby.getScoring().getPlayers()) 
            if (player.getColor() != null && player.getColor().equals(color))  return false;
        return true;
    }

    public static boolean isPainter (Player player) {
        return player.equals(ManagerLobby.myLobby.getGame().currentTurn().getPlayer());
    }
}
