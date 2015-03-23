package controller.impl.command.menu;

import controller.interfaces.Command;
import model.manager.ManagerMenu;

public class ShowMenuCommand implements Command {
    @Override
    public void execute() {
        ManagerMenu.menuFrame.setVisible(true);
    }
}
