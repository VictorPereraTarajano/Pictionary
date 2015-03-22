package controller.impl.command.popups.palette;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

import javax.swing.*;

public class ShowPaletteColourDialogCommand implements Command {

    private JComponent component;

    public ShowPaletteColourDialogCommand(JComponent component) {
        this.component = component;
    }

    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDialog().getPaletteColourDialog().show(component, component.getLocation().x - 100, component.getLocation().y - 5);
    }
}
