package controller.impl.command.scoring;

import controller.interfaces.Command;
import model.manager.ManagerLobby;
import model.manager.ManagerMenu;
import model.player.Player;

public class RemovePlayerScoringCommand implements Command {

    private Player player;

    public RemovePlayerScoringCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        if (ManagerLobby.myPlayer.equals(player)) {
            ManagerLobby.myLobbyFrame.setVisible(false);
            ManagerMenu.menuFrame.setVisible(true);
        } else {
            ManagerLobby.myLobby.getScoring().remove(player);
            ManagerLobby.myLobbyFrame.getScoringPanel().refresh();
        }
    }
}
