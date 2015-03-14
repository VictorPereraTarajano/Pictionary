package controller.impl.command.lobby;

import controller.interfaces.Command;
import model.game.Lobby;
import model.manager.ManagerLobby;
import model.player.Player;

public class HostMigrationCommand implements Command {

    private Player player;
    private Lobby lobby;

    public HostMigrationCommand(Player player, Lobby lobby) {
        this.player = player;
        this.lobby = lobby;
    }

    @Override
    public void execute() {
        ManagerLobby.myLobby=lobby;
        ManagerLobby.myLobby.host=player;
    }
}
