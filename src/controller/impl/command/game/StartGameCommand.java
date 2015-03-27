package controller.impl.command.game;

import controller.impl.command.chat.TypeChatCommand;
import controller.impl.command.turn.StartTurnCommand;
import controller.impl.sendcommand.SendCommand;
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
        if (ManagerLobby.myLobby.getScoring().size() >= ManagerGame.MIN_NUM_PLAYERS) {
            ManagerGame.GAME_STATE=ManagerGame.IN_GAME;
            if (ManagerLobby.myLobby.getHost().equals(ManagerLobby.myPlayer)) {
                ManagerLobby.myLobby.setGame(new GameBuilder().load());
                new SendCommand(new TypeChatCommand(new ChatMessage(new Player("Admin","", Color.black), getInstructions())), ManagerConnection.TCPBroadcastAll()).execute();
                new SendCommand(new StartTurnCommand(ManagerLobby.myLobby.getGame().currentTurn()), ManagerConnection.TCPBroadcastAll()).execute();
            }
        }
    }

    private String getInstructions () {
       return "<b>INSTRUCCIONES:</b> Los jugadores deben adivinar la palabra <br>" +
                "basandose en los dibujos del pintor. <br>" +
                "Los puntos obtenidos se basarán en el tiempo que tardes<br>" +
                "en aceptar la palabra.<br><br>" +
                "<p><b>-   No esta permitido ayudar al resto de jugadores<br>" +
                "para aceptar la palabra.<br>" +
                "   -   No está permitido que el pintor escriba palabras.</b></p><br>" +
               "<p>Si ven que el pintor no cumple las normas pulse el botón<br>" +
                "REPORTAR en la esquina superior derecha.</p><br>";
    }
}
