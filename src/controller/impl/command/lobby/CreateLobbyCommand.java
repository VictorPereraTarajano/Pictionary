package controller.impl.command.lobby;

import controller.interfaces.Command;
import model.game.Lobby;
import model.net.manager.ManagerConnection;
import view.ui.frame.impl.swing.LobbyFrame;
import view.ui.frame.managerlobby.ManagerLobby;

public class CreateLobbyCommand implements Command {

    @Override
    public void execute() {
        ManagerLobby.myLobby=new Lobby();
        ManagerLobby.myLobbyFrame=new LobbyFrame(ManagerLobby.myLobby);
    }
}
