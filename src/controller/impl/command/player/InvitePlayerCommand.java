package controller.impl.command.player;

import controller.interfaces.Command;
import model.manager.ManagerLobby;
import view.ui.dialog.impl.swing.inviteplayerdialog.InvitePlayerDialog;

public class InvitePlayerCommand implements Command {
    @Override
    public void execute() {
        if (ManagerLobby.host.equals(ManagerLobby.myPlayer)) new InvitePlayerDialog();
    }
}
