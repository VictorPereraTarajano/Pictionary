package controller.impl.command.player;

import controller.interfaces.Command;
import model.game.Lobby;
import model.player.Player;
import view.ui.display.impl.swing.InvitePlayerDisplay;

public class ShowInvitePlayerDisplayCommand implements Command {

    private Lobby lobby;
    private Player player;

    public ShowInvitePlayerDisplayCommand(Lobby lobby, Player player) {
        this.lobby = lobby;
        this.player = player;
    }

    @Override
    public void execute() {
        new InvitePlayerDisplay(lobby, player);
    }
}
