package model.manager;

import model.game.Lobby;
import model.player.Player;
import view.ui.frame.impl.swing.LobbyFrame;

public class ManagerLobby {

    public static Lobby  myLobby;
    public static LobbyFrame myLobbyFrame;
    public static Player myPlayer;

    public static Player getAnotherHost() {
        return myLobby.getScoring().getPlayers()[1];
        /*Player newHost = myLobby.getScoring().getPlayers()[new Random(System.currentTimeMillis()).nextInt(myLobby.getScoring().getPlayers().length - 1)];
        if (!newHost.equals(myPlayer))
            return newHost;
        return getAnotherHost();*/
    }
}
