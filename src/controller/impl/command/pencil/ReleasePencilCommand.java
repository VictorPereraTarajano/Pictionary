package controller.impl.command.pencil;

import controller.interfaces.Command;

import static model.manager.ManagerLobby.myLobby;
import static model.manager.ManagerLobby.myLobbyFrame;

public class ReleasePencilCommand implements Command{
    @Override
    public void execute() {
        myLobbyFrame.getCanvasPanel().getCanvasDisplay().setLastPoint(null);
        myLobby.getCanvas().clear();
        myLobbyFrame.getCanvasPanel().refresh();
    }
}
