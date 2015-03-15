package controller.impl.command.game.turn;

import controller.impl.command.chat.TypeChatCommand;
import controller.impl.command.timer.UpdateTimerCommand;
import controller.impl.sendcommand.SendMessageCommand;
import controller.interfaces.Command;
import model.chat.ChatMessage;
import model.game.Turn;
import model.manager.ManagerConnection;
import model.player.Player;
import model.timer.Timer;

import java.awt.*;

import static model.manager.ManagerLobby.myLobby;

public class StartTurnCommand implements Command {

    private Turn turn;

    public StartTurnCommand(Turn turn) {
        this.turn = turn;
    }

    @Override
    public void execute() {
        new SendMessageCommand(new UpdateTimerCommand(Timer.initCount), ManagerConnection.TCPBroadcastAll()).execute();
        new SendMessageCommand(new TypeChatCommand(new ChatMessage(new Player("Admin","", Color.black), turn.getPlayer()+" va a dibujar  ... ")), ManagerConnection.TCPBroadcastAll()).execute();
        myLobby.getTimer().start();
    }
}
