package model.game;

import model.manager.ManagerLobby;

import java.util.Random;

public class GameBuilder {
    public Game load() {
        Game game = new Game();
        Random r = new Random(System.nanoTime());
        for (int i = 0; i < Game.MAX_TURNS; i++)
            game.addTurn(new Turn(game.getWordSet().get(r.nextInt(game.getWordSet().size())), ManagerLobby.myLobby.getScoring().getPlayers()[r.nextInt(ManagerLobby.myLobby.getScoring().size())]));
        return game;
    }
}
