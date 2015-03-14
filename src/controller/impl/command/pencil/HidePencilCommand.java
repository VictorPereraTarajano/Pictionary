package controller.impl.command.pencil;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class HidePencilCommand implements Command {

    @Override
    public void execute() {
        ManagerLobby.myLobby.getCanvas().getPencil().setVisible(false);
        ManagerLobby.myLobbyFrame.getCanvasPanel().refresh();
    }
}