package controller.impl.command.game;

import controller.impl.command.chat.TypeChatCommand;
import controller.impl.command.game.turn.StartTurnCommand;
import controller.impl.sendcommand.SendMessageCommand;
import controller.interfaces.Command;
import model.chat.ChatMessage;
import model.game.GameBuilder;
import model.manager.ManagerConnection;
import model.manager.ManagerGame;
import model.manager.ManagerLobby;
import model.player.Player;

import java.awt.*;

public class StartGameCommand implements Command {

    @Override
    public void execute() {
        if (ManagerLobby.myLobby.getScoring().size() >= ManagerGame.MIN_NUM_PLAYERS && ManagerLobby.myLobby.host.equals(ManagerLobby.myPlayer)) {
            ManagerLobby.myLobby.setGame(new GameBuilder().load());
            new SendMessageCommand(new TypeChatCommand(new ChatMessage(new Player("Admin","", Color.black), "La partida está a punto de empezar  ... ")), ManagerConnection.TCPBroadcastAll()).execute();
            new SendMessageCommand(new StartTurnCommand(ManagerLobby.myLobby.getGame().currentTurn()), ManagerConnection.TCPBroadcastAll()).execute();

        }
    }
}
