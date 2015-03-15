package controller.impl.command.player;

import controller.interfaces.Command;
import model.manager.ManagerLobby;
import view.ui.dialog.impl.swing.KickPlayerDialog;

public class KickPlayerCommand implements Command {

    @Override
    public void execute() {
        if (ManagerLobby.myLobby.getHost().equals(ManagerLobby.myPlayer)) new KickPlayerDialog();
    }
}
