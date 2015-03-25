package controller.impl.command.frame.timer;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class ShowTimerPanelCommand implements Command {
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getTimerPanel().setVisible(false);
    }
}
