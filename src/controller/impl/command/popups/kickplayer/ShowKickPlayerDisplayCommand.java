package controller.impl.command.popups.kickplayer;

import controller.interfaces.Command;
import view.ui.display.impl.swing.KickPlayerDisplay;

public class ShowKickPlayerDisplayCommand implements Command {

    private String message;

    public ShowKickPlayerDisplayCommand(String message) {
        this.message = message;
    }

    @Override
    public void execute() {
        new KickPlayerDisplay(message).display();
    }
}
