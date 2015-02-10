package controller.impl.lobby;

import controller.interfaces.Command;
import model.game.Lobby;
import model.message.impl.state.interfaces.SendStateMessage;
import view.frame.impl.swing.LobbyFrame;

public class CreateLobbyCommand implements Command {

    @Override
    public void execute() {
        LobbyFrame lobbyFrame = new LobbyFrame(new Lobby());
        SendStateMessage.LobbyFrame=lobbyFrame;
    }
}
