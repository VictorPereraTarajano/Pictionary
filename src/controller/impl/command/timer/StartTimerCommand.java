package controller.impl.command.timer;

import controller.interfaces.Command;
import model.manager.ManagerLobby;
import model.timer.Timer;

public class StartTimerCommand implements Command {
    @Override
    public void execute() {
        ManagerLobby.myLobby.getTimer().setCount(Timer.initCount);
        ManagerLobby.myLobby.getTimer().start();
    }
}
