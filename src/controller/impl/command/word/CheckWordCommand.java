package controller.impl.command.word;

import controller.impl.command.chat.TypeChatCommand;
import controller.impl.command.editable.chat.DisableChatDialogCommand;
import controller.impl.command.scoring.UpdatePlayerScoringCommand;
import controller.impl.command.turn.StopTurnCommand;
import controller.impl.command.turn.UpdateTurnCommand;
import controller.impl.sendcommand.SendCommand;
import controller.interfaces.Command;
import model.chat.ChatMessage;
import model.manager.ManagerConnection;
import model.manager.ManagerGame;
import model.manager.ManagerLobby;
import model.player.Player;
import model.scoring.Score;
import model.word.Word;
import view.process.WordMatcher;

public class CheckWordCommand implements Command {

    private Word word;

    public CheckWordCommand(Word word) {
        this.word = word;
    }

    @Override
    public void execute() {
        if (ManagerGame.GAME_STATE == ManagerGame.IN_GAME && WordMatcher.match(word, ManagerLobby.myLobby.getGame().currentTurn().getWord())) {
            new SendCommand(new UpdatePlayerScoringCommand(ManagerLobby.myPlayer, new Score(ManagerLobby.myLobby.getTimer().getCount())), ManagerConnection.TCPBroadcastAll()).execute();
            new SendCommand(new UpdateTurnCommand(ManagerLobby.myPlayer), ManagerConnection.TCPBroadcastAll()).execute();
            if (ManagerLobby.myLobby.getGame().currentTurn().isFinished())
                new SendCommand(new StopTurnCommand("Turno finalizado"), ManagerConnection.TCPBroadcast(new Player[] {ManagerLobby.myLobby.getHost()})).execute();
            new DisableChatDialogCommand().execute();
        } else
            new SendCommand(new TypeChatCommand(new ChatMessage(ManagerLobby.myPlayer, word.getVisibleWord())), ManagerConnection.TCPBroadcastAll()).execute();
    }

}
