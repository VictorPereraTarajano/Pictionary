package controller.impl.command.popups.reportplayer;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class HideReportPlayerDialogCommand implements Command {
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getCanvasPanel().getReportPlayerDialog().setVisible(false);
    }
}
