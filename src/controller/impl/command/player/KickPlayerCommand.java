package controller.impl.command.player;

import controller.interfaces.Command;
import model.game.Lobby;
import model.manager.ManagerLobby;
import view.ui.dialog.impl.swing.kickplayerdialog.KickPlayerDialog;

public class KickPlayerCommand implements Command {

    private Lobby lobby;

    public KickPlayerCommand(Lobby lobby) {
        this.lobby = lobby;
    }

    @Override
    public void execute() {
        if (ManagerLobby.ownerLobby.equals(ManagerLobby.myPlayer)) new KickPlayerDialog(lobby);
    }
}
