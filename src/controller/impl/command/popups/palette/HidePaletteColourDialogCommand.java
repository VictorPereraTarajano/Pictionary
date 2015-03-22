package controller.impl.command.popups.palette;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class HidePaletteColourDialogCommand implements Command {

    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDialog().getPaletteColourDialog().setVisible(false);
    }
}
