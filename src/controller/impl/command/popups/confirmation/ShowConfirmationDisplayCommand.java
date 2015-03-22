package controller.impl.command.popups.confirmation;

import controller.interfaces.Command;
import model.player.Player;
import view.ui.display.impl.swing.ConfirmationDisplay;

public class ShowConfirmationDisplayCommand implements Command {

    private Player player;

    public ShowConfirmationDisplayCommand(Player player) {
        this.player=player;
    }

    @Override
    public void execute() {
        new ConfirmationDisplay(player);
    }
}
