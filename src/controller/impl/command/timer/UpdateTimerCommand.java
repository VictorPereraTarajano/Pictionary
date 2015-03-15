package controller.impl.command.timer;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class UpdateTimerCommand implements Command {

    private int time;

    public UpdateTimerCommand(int time) {
        this.time = time;
    }

    @Override
    public void execute() {
        ManagerLobby.myLobby.getTimer().setCount(time);
        ManagerLobby.myLobbyFrame.getTimerPanel().refresh(time);
    }
}
