package controller.impl.command.popups.canvas.reportplayer;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class ShowReportPlayerDialog implements Command {
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getCanvasPanel().getReportPlayerDialog().setVisible(false);
    }
}
