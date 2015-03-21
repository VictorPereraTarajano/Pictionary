package controller.impl.command.popups.canvas.palette;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class HidePaletteColourDialog implements Command {

    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDialog().getPaletteColourDialog().setVisible(false);
    }
}
