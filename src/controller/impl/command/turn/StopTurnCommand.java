package controller.impl.command.turn;

import controller.impl.command.chat.TypeChatCommand;
import controller.impl.sendcommand.SendCommand;
import controller.interfaces.Command;
import model.chat.ChatMessage;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.player.Player;

import java.awt.*;

public class StopTurnCommand implements Command {

    @Override
    public void execute() {
        new TypeChatCommand(new ChatMessage(new Player("Admin", "", Color.black), "El pintor "+ManagerLobby.myLobby.getGame().currentTurn().getPlayer().getName()+" ha cancelado el turno")).execute();
        if (ManagerLobby.myPlayer.equals(ManagerLobby.myLobby.getHost()))
            new SendCommand(new StartTurnCommand(ManagerLobby.myLobby.getGame().nextTurn()), ManagerConnection.TCPBroadcastAll()).execute();
    }
}
