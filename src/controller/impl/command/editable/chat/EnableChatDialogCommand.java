package controller.impl.command.editable.chat;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class EnableChatDialogCommand implements Command {
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getChatPanel().getChatDialog().setEditable(true);
    }
}
