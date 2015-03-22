package controller.impl.command.popups.kickplayer;

import controller.interfaces.Command;
import view.ui.dialog.impl.swing.KickPlayerDialog;

public class ShowKickPlayerDialogCommand implements Command {
    @Override
    public void execute() {
        new KickPlayerDialog();
    }
}
