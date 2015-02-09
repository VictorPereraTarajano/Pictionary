package controller.impl.lobby;

import controller.interfaces.Command;
import model.game.Lobby;

public class CreateLobbyCommand implements Command {

    private Lobby lobby;

    @Override
    public void execute() {
        lobby = new Lobby();
    }
}
