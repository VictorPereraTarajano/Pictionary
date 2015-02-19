package model.game;

import model.manager.ManagerLobby;

import java.util.Random;

public class GameBuilder {
    public Game load() {
        Game game = new Game();
        for (int i = 0; i < Game.MAX_TURNS; i++) {
            game.addTurn(new Turn(game.getWordSet().get(new Random(System.currentTimeMillis()).nextInt(game.getWordSet().size() - 1)), ManagerLobby.myLobby.getScoring().getPlayers()[new Random(System.currentTimeMillis()).nextInt(ManagerLobby.myLobby.getScoring().size())]));
        }
        return game;
    }
}
