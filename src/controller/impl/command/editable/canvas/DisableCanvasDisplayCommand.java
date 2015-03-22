package controller.impl.command.editable.canvas;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class DisableCanvasDisplayCommand implements Command {
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().setEditable(false);
    }
}
