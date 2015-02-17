package controller.impl.command.lobby;

import controller.impl.command.connection.ConnectCommand;
import controller.interfaces.Command;
import model.game.Lobby;
import model.manager.ManagerConnection;
import view.ui.frame.impl.swing.LobbyFrame;
import model.manager.ManagerLobby;

public class CreateLobbyCommand implements Command {

    @Override
    public void execute() {
        if (ManagerConnection.getStatus().equals("DISCONNECTED")) new ConnectCommand().execute();
        ManagerLobby.myLobby=new Lobby();
        ManagerLobby.myLobbyFrame=new LobbyFrame();
        ManagerLobby.myLobby.host =ManagerLobby.myPlayer;
    }
}
