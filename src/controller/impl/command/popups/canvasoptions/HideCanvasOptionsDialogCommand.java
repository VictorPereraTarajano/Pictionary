package controller.impl.command.popups.canvasoptions;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class HideCanvasOptionsDialogCommand implements Command {
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDialog().setVisible(false);
    }
}
