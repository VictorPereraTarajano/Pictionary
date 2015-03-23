package controller.impl.command.word;

import controller.impl.command.chat.TypeChatCommand;
import controller.impl.command.scoring.UpdatePlayerScoringCommand;
import controller.impl.sendcommand.SendCommand;
import controller.interfaces.Command;
import model.chat.ChatMessage;
import model.manager.ManagerConnection;
import model.manager.ManagerGame;
import model.manager.ManagerLobby;
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
        if (ManagerGame.GAME_STATE == ManagerGame.IN_GAME && WordMatcher.match(word, ManagerLobby.myLobby.getGame().currentTurn().getWord()))
            new SendCommand(new UpdatePlayerScoringCommand(ManagerLobby.myPlayer, new Score(ManagerLobby.myLobby.getTimer().getCount())), ManagerConnection.TCPBroadcastAll()).execute();
        else
            new SendCommand(new TypeChatCommand(new ChatMessage(ManagerLobby.myPlayer, word.getWord())), ManagerConnection.TCPBroadcastAll()).execute();
    }
}
