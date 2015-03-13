package controller.impl.command.pencil;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class ReleasePencilCommand implements Command {
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().setLastPoint(null);
        ManagerLobby.myLobby.getCanvas().clear();
    }
}
