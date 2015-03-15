package controller.impl.command.pencil.options;

import controller.interfaces.Command;

import java.awt.*;

import static model.manager.ManagerLobby.myLobby;

public class UpdatePencilColorCommand implements Command {

    private Color color;

    public UpdatePencilColorCommand(Color color) {
        this.color = color;
    }

    @Override
    public void execute() {
        myLobby.getCanvas().getPencil().setColor(color);
    }
}
