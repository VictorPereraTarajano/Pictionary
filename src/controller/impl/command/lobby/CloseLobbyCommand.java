package controller.impl.command.lobby;

import controller.impl.command.scoring.RemovePlayerScoringCommand;
import controller.impl.sendcommand.SendMessageCommand;
import controller.interfaces.Command;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.player.Player;

public class CloseLobbyCommand implements Command {

    private Player player;

    public CloseLobbyCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        if (ManagerLobby.myLobby.host.equals(player) && ManagerLobby.myLobby.getScoring().size() > 1)
            new SendMessageCommand(new HostMigrationCommand(ManagerLobby.getAnotherHost(), ManagerLobby.myLobby), ManagerConnection.TCPBroadcast()).execute();
        new SendMessageCommand(new RemovePlayerScoringCommand(player), ManagerConnection.TCPBroadcastAll()).execute();
    }
}
