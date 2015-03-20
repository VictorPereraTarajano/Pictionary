package controller.impl.command.player.popups;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class HidePaletteColourDialog implements Command {

    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDialog().getPaletteColourDialog().setVisible(false);
    }
}
