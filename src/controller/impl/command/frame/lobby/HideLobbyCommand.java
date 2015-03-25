package controller.impl.command.frame.lobby;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class HideLobbyCommand implements Command {
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.setVisible(false);
    }
}
