package controller.impl.command.word;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class ShowWordDisplayCommand implements Command {
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getWordPanel().getWordDisplay().setVisible(true);
        ManagerLobby.myLobbyFrame.getWordPanel().refresh();
    }
}
