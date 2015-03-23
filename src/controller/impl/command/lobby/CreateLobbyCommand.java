package controller.impl.command.lobby;

import controller.impl.command.connection.ConnectCommand;
import controller.interfaces.Command;
import model.game.Lobby;
import model.manager.ManagerGame;
import model.manager.ManagerLobby;
import view.ui.frame.impl.swing.LobbyFrame;

public class CreateLobbyCommand implements Command {

    private Lobby lobby;

    public CreateLobbyCommand (Lobby lobby) {
        this.lobby=lobby;
    }

    @Override
    public void execute() {
        new ConnectCommand().execute();
        ManagerLobby.myLobby=lobby;
        ManagerLobby.myLobbyFrame=new LobbyFrame();
        ManagerLobby.myPlayer.setColor(ManagerGame.getAvailableColor());
        if (ManagerLobby.myLobby.getHost() == null)
            ManagerLobby.myLobby.setHost(ManagerLobby.myPlayer);
        ManagerLobby.myLobbyFrame.setVisible(true);
    }
}
