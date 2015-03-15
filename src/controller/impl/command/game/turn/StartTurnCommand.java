package controller.impl.command.game.turn;

import controller.impl.command.chat.TypeChatCommand;
import controller.impl.command.timer.StartTimerCommand;
import controller.interfaces.Command;
import model.chat.ChatMessage;
import model.game.Turn;
import model.manager.ManagerLobby;
import model.player.Player;

import java.awt.*;

public class StartTurnCommand implements Command {

    private Turn turn;

    public StartTurnCommand(Turn turn) {
        this.turn = turn;
    }

    @Override
    public void execute() {
        ManagerLobby.myLobby.getTimer().stop();
        initChat();
         if (ManagerLobby.myPlayer.equals(turn.getPlayer())) {
             ManagerLobby.myLobbyFrame.getChatPanel().getChatDialog().setEditable(false);
             ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().setEditable(true);
         } else {
             ManagerLobby.myLobbyFrame.getChatPanel().getChatDialog().setEditable(true);
             ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().setEditable(false);
         }
        if (!ManagerLobby.myLobby.host.equals(ManagerLobby.myPlayer))
            ManagerLobby.myLobby.getGame().addTurn(turn);
        else
            initTimer();
        initWordDisplay();
    }

    private void initWordDisplay () {
        ManagerLobby.myLobbyFrame.getWordPanel().getWordDisplay().setVisible(true);
        ManagerLobby.myLobbyFrame.getWordPanel().refresh();
    }

    private void initTimer () {
        new StartTimerCommand().execute();
    }

    private void initChat () {
        new TypeChatCommand(new ChatMessage(new Player("Admin", "", Color.black), turn.getPlayer()+" va a dibujar")).execute();
    }
}
