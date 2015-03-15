package controller.impl.command.pencil.options;

import controller.interfaces.Command;

import java.awt.*;

import static model.manager.ManagerLobby.myLobby;

public class UpdatePencilDimensionCommand implements Command {

    private Dimension dimension;

    public UpdatePencilDimensionCommand(Dimension dimension) {
        this.dimension = dimension;
    }

    @Override
    public void execute() {
        myLobby.getCanvas().getPencil().setDimension(dimension);
    }
}
