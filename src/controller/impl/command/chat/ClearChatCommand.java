package controller.impl.command.chat;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class ClearChatCommand implements Command  {
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getChatPanel().clear();
    }
}
