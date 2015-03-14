package controller.impl.command.lobby;

import controller.impl.command.connection.ConnectCommand;
import controller.interfaces.Command;
import model.game.Lobby;
import model.manager.ManagerConnection;
import model.manager.ManagerGame;
import view.ui.frame.impl.swing.LobbyFrame;
import model.manager.ManagerLobby;

public class CreateLobbyCommand implements Command {

    private Lobby lobby;

    public CreateLobbyCommand (Lobby lobby) {
        this.lobby=lobby;
    }

    @Override
    public void execute() {
        if (ManagerConnection.getStatus().equals("DISCONNECTED")) new ConnectCommand().execute();
        ManagerLobby.myLobby=lobby;
        ManagerLobby.myLobbyFrame=new LobbyFrame();
        ManagerLobby.myPlayer.setColor(ManagerGame.getAvailableColor());
        ManagerLobby.myLobby.host =ManagerLobby.myPlayer;
        ManagerLobby.myLobbyFrame.setVisible(true);
    }
}
