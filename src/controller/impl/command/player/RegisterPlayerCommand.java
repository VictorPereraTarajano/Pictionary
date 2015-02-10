package controller.impl.command.player;

import controller.interfaces.Command;
import view.ui.dialog.impl.swing.RegisterPlayerDialog;

public class RegisterPlayerCommand implements Command {
    @Override
    public void execute() {
        new RegisterPlayerDialog().setModal(false);
    }
}
