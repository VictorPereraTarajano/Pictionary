package controller.impl.command.turn;

import controller.interfaces.Command;
import model.manager.ManagerLobby;
import model.player.Player;

public class UpdateTurnCommand implements Command  {

    private Player player;

    public UpdateTurnCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        ManagerLobby.myLobby.getGame().currentTurn().setAsserted(player);
    }
}
