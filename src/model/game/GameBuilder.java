package model.game;

import model.manager.ManagerGame;
import model.manager.ManagerLobby;
import model.player.Player;

import java.util.ArrayList;
import java.util.Random;

public class GameBuilder {
    public Game load() {
        Game game = new Game();
        Random r = new Random(System.nanoTime());
        for (int i = 0; i < ManagerGame.NUM_MAX_TURNS; i++) {
            int random = r.nextInt(ManagerLobby.myLobby.getScoring().size());
            game.addTurn(new Turn(game.getWordSet().get(r.nextInt(game.getWordSet().size())), ManagerLobby.myLobby.getScoring().getPlayers()[random], nonPainterPlayers(ManagerLobby.myLobby.getScoring().getPlayers()[random])));
        }
        return game;
    }

    private Player[] nonPainterPlayers (Player painter) {
        ArrayList<Player> list = new ArrayList<>();
        for (Player player : ManagerLobby.myLobby.getScoring().getPlayers())  if (!player.equals(painter)) list.add(player);
        return list.toArray(new Player[list.size()]);
    }
}
