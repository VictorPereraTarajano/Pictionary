package controller.impl.command.popups;

import controller.interfaces.Command;
import model.manager.ManagerLobby;
import view.ui.dialog.impl.swing.InvitePlayerDialog;

public class ShowInvitePlayerDialogCommand implements Command {
    @Override
    public void execute() {
        if (ManagerLobby.myLobby.getHost().equals(ManagerLobby.myPlayer)) new InvitePlayerDialog();
    }
}
