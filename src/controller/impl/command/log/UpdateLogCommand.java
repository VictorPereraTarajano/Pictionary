package controller.impl.command.log;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class UpdateLogCommand implements Command{

    private  String message;

    public UpdateLogCommand(String message) {
        this.message = message;
    }

    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getLogLabel().setText(message);
    }
}
