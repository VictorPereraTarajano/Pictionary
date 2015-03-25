package controller.impl.command.frame.scoring;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class HideScoringPanelCommand implements Command{
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getScoringPanel().setVisible(false);
    }
}
