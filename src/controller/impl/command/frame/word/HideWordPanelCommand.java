package controller.impl.command.frame.word;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class HideWordPanelCommand implements Command {
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getWordPanel().setVisible(false);
    }
}
