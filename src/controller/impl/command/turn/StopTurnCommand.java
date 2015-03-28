package controller.impl.command.turn;

import controller.impl.command.chat.TypeChatCommand;
import controller.impl.command.game.StopGameCommand;
import controller.impl.command.results.ShowResultsCommand;
import controller.impl.sendcommand.SendCommand;
import controller.interfaces.Command;
import model.chat.ChatMessage;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.player.Player;

import java.awt.*;

public class StopTurnCommand implements Command {

    private String message;

    public StopTurnCommand(String message) {
        this.message = message;
    }

    @Override
    public void execute() {
        if (ManagerLobby.myLobby.getGame().isFinished()) {
            new SendCommand(new StopGameCommand(), ManagerConnection.TCPBroadcastAll()).execute();
            new SendCommand(new TypeChatCommand(new ChatMessage(new Player("Admin", "Finalizado el juego", Color.black), message)), ManagerConnection.TCPBroadcastAll()).execute();
            new SendCommand(new ShowResultsCommand(ManagerLobby.myLobby.getScoring()), ManagerConnection.TCPBroadcastAll()).execute();
        }  else {
            new TypeChatCommand(new ChatMessage(new Player("Admin", "Finalizado el turno", Color.black), message)).execute();
            new SendCommand(new StartTurnCommand(ManagerLobby.myLobby.getGame().nextTurn()), ManagerConnection.TCPBroadcastAll()).execute();
        }
    }
}
