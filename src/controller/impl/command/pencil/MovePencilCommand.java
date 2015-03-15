package controller.impl.command.pencil;

import controller.interfaces.Command;

import java.awt.*;

import static model.manager.ManagerLobby.myLobby;
import static model.manager.ManagerLobby.myLobbyFrame;

public class MovePencilCommand implements Command {

    private Point point;

    public MovePencilCommand(Point point) {
        this.point = point;
    }

    @Override
    public void execute() {
        myLobby.getCanvas().getPencil().setPosition(point);
        myLobby.getCanvas().getPencil().setVisible(true);
        myLobbyFrame.getCanvasPanel().refresh();
    }
}
