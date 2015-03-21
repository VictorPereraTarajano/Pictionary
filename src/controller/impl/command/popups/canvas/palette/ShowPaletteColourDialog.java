package controller.impl.command.popups.canvas.palette;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

import javax.swing.*;

public class ShowPaletteColourDialog implements Command {

    private JComponent component;

    public ShowPaletteColourDialog(JComponent component) {
        this.component = component;
    }

    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDialog().getPaletteColourDialog().show(component, component.getLocation().x - 100, component.getLocation().y - 5);
    }
}
