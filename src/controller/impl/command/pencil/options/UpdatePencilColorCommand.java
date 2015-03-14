package controller.impl.command.pencil.options;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

import java.awt.*;

public class UpdatePencilColorCommand implements Command {

    private Color color;

    public UpdatePencilColorCommand(Color color) {
        this.color = color;
    }

    @Override
    public void execute() {
        ManagerLobby.myLobby.getCanvas().getPencil().setColor(color);
    }
}
