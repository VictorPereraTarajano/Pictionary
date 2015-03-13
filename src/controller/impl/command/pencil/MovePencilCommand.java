package controller.impl.command.pencil;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

import java.awt.*;

public class MovePencilCommand implements Command {

    private Point point;

    public MovePencilCommand(Point point) {
        this.point = point;
    }

    @Override
    public void execute() {
        ManagerLobby.myLobby.getCanvas().getPencil().setPosition(point);
        ManagerLobby.myLobby.getCanvas().getPencil().setVisible(true);
        ManagerLobby.myLobbyFrame.getCanvasPanel().refresh();
    }
}
