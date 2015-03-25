package controller.impl.command.game;

import controller.impl.command.editable.chat.EnableChatDialogCommand;
import controller.impl.sendcommand.SendCommand;
import controller.interfaces.Command;
import model.manager.ManagerConnection;

public class StopGameCommand implements Command {
    @Override
    public void execute() {
        new SendCommand(new EnableChatDialogCommand(), ManagerConnection.TCPBroadcastAll()).execute();
    }
}
