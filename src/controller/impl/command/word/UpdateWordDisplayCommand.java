package controller.impl.command.word;

import controller.interfaces.Command;
import model.manager.ManagerLobby;
import model.word.Word;
import view.process.WordDecoder;

public class UpdateWordDisplayCommand implements Command {
    @Override
    public void execute() {
        Word word = ManagerLobby.myLobby.getGame().currentTurn().getWord();
        word.getWord()[WordDecoder.decode(word)].setVisible(true);
        ManagerLobby.myLobbyFrame.getWordPanel().refresh();
    }
}
