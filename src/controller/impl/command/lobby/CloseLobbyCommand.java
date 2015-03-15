package controller.impl.command.lobby;

import controller.impl.command.scoring.RemovePlayerScoringCommand;
import controller.impl.sendcommand.SendCommand;
import controller.interfaces.Command;
import model.manager.ManagerConnection;
import model.player.Player;

import static model.manager.ManagerLobby.getAnotherHost;
import static model.manager.ManagerLobby.myLobby;

public class CloseLobbyCommand implements Command {

    private Player player;

    public CloseLobbyCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        if (myLobby.getHost().equals(player) && myLobby.getScoring().size() > 1)
            new SendCommand(new HostMigrationCommand(getAnotherHost(), myLobby), ManagerConnection.TCPBroadcast()).execute();
        new SendCommand(new RemovePlayerScoringCommand(player), ManagerConnection.TCPBroadcastAll()).execute();
    }
}
