package controller.impl.command.frame.results;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

import java.awt.*;

public class ShowResultsPanelCommand implements Command {
    @Override
    public void execute() {
        ((CardLayout) ManagerLobby.myLobbyFrame.getResultsPane().getParent().getParent().getLayout()).show(ManagerLobby.myLobbyFrame.getResultsPane().getParent().getParent(), "RESULTS");
    }
}
