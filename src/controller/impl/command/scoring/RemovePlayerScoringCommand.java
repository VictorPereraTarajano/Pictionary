package controller.impl.command.scoring;

import controller.impl.command.chat.TypeChatCommand;
import controller.impl.command.frame.lobby.HideLobbyCommand;
import controller.impl.command.menu.ShowMenuCommand;
import controller.interfaces.Command;
import model.chat.ChatMessage;
import model.manager.ManagerLobby;
import model.player.Player;

import java.awt.*;

public class RemovePlayerScoringCommand implements Command {

    private Player player;

    public RemovePlayerScoringCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        if (ManagerLobby.myPlayer.equals(player)) {
            new HideLobbyCommand().execute();
            new ShowMenuCommand().execute();
        } else {
            new TypeChatCommand(new ChatMessage(new Player("Admin","", Color.BLACK),ManagerLobby.myPlayer.getName()+" has been disconnected")).execute();
            ManagerLobby.myLobby.getScoring().remove(player);
            ManagerLobby.myLobbyFrame.getScoringPanel().refresh();
        }
    }
}
