package controller.impl.command.frame.canvas;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class HideCanvasPanelCommand implements Command {
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getCanvasPanel().setVisible(false);
    }
}
