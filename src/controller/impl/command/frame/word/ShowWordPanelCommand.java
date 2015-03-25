package controller.impl.command.frame.word;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class ShowWordPanelCommand implements Command {
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getWordPanel().setVisible(true);
    }
}
