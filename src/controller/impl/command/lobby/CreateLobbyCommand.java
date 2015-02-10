package controller.impl.command.lobby;

import controller.impl.command.player.RegisterPlayerCommand;
import controller.interfaces.Command;
import model.game.Lobby;
import model.message.impl.state.interfaces.SendStateMessage;
import view.ui.frame.impl.swing.LobbyFrame;

public class CreateLobbyCommand implements Command {

    @Override
    public void execute() {
        LobbyFrame lobbyFrame = new LobbyFrame(new Lobby());
        SendStateMessage.LobbyFrame=lobbyFrame;
    }
}
