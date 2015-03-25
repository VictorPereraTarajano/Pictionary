package controller.impl.command.frame.chat;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class HideChatPanelCommand implements Command{
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getChatPanel().setVisible(false);
    }
}
