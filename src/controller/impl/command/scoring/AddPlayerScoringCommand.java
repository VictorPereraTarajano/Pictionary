package controller.impl.command.scoring;

import controller.interfaces.Command;
import model.manager.ManagerGame;
import model.manager.ManagerLobby;
import model.player.Player;
import model.scoring.Score;

public class AddPlayerScoringCommand implements Command {

    private Player player;

    public AddPlayerScoringCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.setColor(ManagerGame.getAvailableColor());
        ManagerLobby.myLobby.getScoring().add(player, new Score(0));
        ManagerLobby.myLobbyFrame.getScoringPanel().refresh();
    }
}
