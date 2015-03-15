package controller.impl.command.pencil;

import controller.interfaces.Command;

import java.awt.*;

import static model.manager.ManagerLobby.myLobby;
import static model.manager.ManagerLobby.myLobbyFrame;

public class DrawPencilCommand implements Command {

    private Point point;

    public DrawPencilCommand(Point point) {
        this.point = point;
    }

    @Override
    public void execute() {
        myLobby.getCanvas().getPencil().setPosition(point);
        myLobby.getCanvas().add(point);
        if (myLobby.getCanvas().getPointList().size() > model.canvas.Canvas.MAX_SIZE_BUFFER) {
            myLobby.getCanvas().getPencil().setPainting(true);
            myLobby.getCanvas().getPencil().setVisible(true);
            myLobbyFrame.getCanvasPanel().refresh();
        }
    }
}
