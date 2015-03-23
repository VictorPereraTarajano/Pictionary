package controller.impl.command.scoring;

import controller.interfaces.Command;
import model.manager.ManagerLobby;
import model.player.Player;
import model.scoring.Score;

public class UpdatePlayerScoringCommand implements Command {

    private Player player;
    private Score score;

    public UpdatePlayerScoringCommand(Player player, Score score) {
        this.score=score;
        this.player = player;
    }

    @Override
    public void execute() {
        ManagerLobby.myLobby.getScoring().add(player, score);
        ManagerLobby.myLobbyFrame.getScoringPanel().refresh();
    }
}
