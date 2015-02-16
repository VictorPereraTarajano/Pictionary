package controller.impl.command.player;

import controller.interfaces.Command;
import model.game.Lobby;
import model.manager.ManagerLobby;
import view.ui.dialog.impl.swing.kickplayerdialog.KickPlayerDialog;

public class KickPlayerCommand implements Command {

    @Override
    public void execute() {
        if (ManagerLobby.host.equals(ManagerLobby.myPlayer)) new KickPlayerDialog();
    }
}
