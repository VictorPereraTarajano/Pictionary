package controller.impl.command.pencil.options;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

import java.awt.*;

public class UpdatePencilDimensionCommand implements Command {

    private Dimension dimension;

    public UpdatePencilDimensionCommand(Dimension dimension) {
        this.dimension = dimension;
    }

    @Override
    public void execute() {
        ManagerLobby.myLobby.getCanvas().getPencil().setDimension(dimension);
    }
}
