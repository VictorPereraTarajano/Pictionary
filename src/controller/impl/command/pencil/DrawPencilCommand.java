package controller.impl.command.pencil;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

import java.awt.*;

public class DrawPencilCommand implements Command {

    private Point point;

    public DrawPencilCommand(Point point) {
        this.point = point;
    }

    @Override
    public void execute() {
        ManagerLobby.myLobby.getCanvas().getPencil().setPosition(point);
        ManagerLobby.myLobby.getCanvas().add(point);
        if (ManagerLobby.myLobby.getCanvas().getPointList().size() > 10) {
            ManagerLobby.myLobby.getCanvas().getPencil().setPainting(true);
            ManagerLobby.myLobby.getCanvas().getPencil().setVisible(true);
            ManagerLobby.myLobbyFrame.getCanvasPanel().refresh();
        }
    }
}
