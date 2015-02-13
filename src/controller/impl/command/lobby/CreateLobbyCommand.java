package controller.impl.command.lobby;

import controller.interfaces.Command;
import model.game.Lobby;
import view.ui.frame.impl.swing.LobbyFrame;
import model.manager.ManagerLobby;

public class CreateLobbyCommand implements Command {

    @Override
    public void execute() {
        ManagerLobby.myLobby=new Lobby();
        ManagerLobby.myLobbyFrame=new LobbyFrame(ManagerLobby.myLobby);
    }
}
