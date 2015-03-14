package controller.impl.command.canvas;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class ClearCanvasCommand implements Command {
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().setLastPoint(null);
        ManagerLobby.myLobby.getCanvas().clear();
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().clear();
        ManagerLobby.myLobbyFrame.getCanvasPanel().refresh();
    }
}
