package controller.impl.command.player.popups;

import controller.interfaces.Command;
import view.ui.dialog.impl.swing.KickPlayerDialog;

public class ShowKickPlayerDialogCommand implements Command {
    @Override
    public void execute() {
        new KickPlayerDialog();
    }
}
