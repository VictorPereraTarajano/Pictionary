package controller.impl.command.lobby;

import controller.interfaces.Command;
import model.game.Lobby;
import model.player.Player;

import static model.manager.ManagerLobby.myLobby;

public class HostMigrationCommand implements Command {

    private Player player;
    private Lobby lobby;

    public HostMigrationCommand(Player player, Lobby lobby) {
        this.player = player;
        this.lobby = lobby;
    }

    @Override
    public void execute() {
        myLobby=lobby;
        myLobby.setHost(player);
    }
}
