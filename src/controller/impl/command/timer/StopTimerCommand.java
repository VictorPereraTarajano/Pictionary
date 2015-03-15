package controller.impl.command.timer;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class StopTimerCommand implements Command {
    @Override
    public void execute() {
        ManagerLobby.myLobby.getTimer().stop();
    }
}
