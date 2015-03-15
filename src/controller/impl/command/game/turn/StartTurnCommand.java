package controller.impl.command.game.turn;

import controller.impl.command.canvas.ClearCanvasCommand;
import controller.impl.command.chat.TypeChatCommand;
import controller.impl.command.timer.StartTimerCommand;
import controller.impl.command.timer.StopTimerCommand;
import controller.interfaces.Command;
import model.chat.ChatMessage;
import model.game.Turn;
import model.manager.ManagerLobby;
import model.player.Player;
import view.persistence.impl.ClipSoundLoader;

import java.awt.*;

public class StartTurnCommand implements Command {

    private Turn turn;

    public StartTurnCommand(Turn turn) {
        this.turn = turn;
    }

    @Override
    public void execute() {
        new StopTimerCommand().execute();
        initChat();
        initCanvas();
         if (ManagerLobby.myPlayer.equals(turn.getPlayer())) {
             ManagerLobby.myLobbyFrame.getChatPanel().getChatDialog().setEditable(false);
             ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().setEditable(true);
         } else {
             ManagerLobby.myLobbyFrame.getChatPanel().getChatDialog().setEditable(true);
             ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().setEditable(false);
         }
        initAnimation();
        initWordDisplay();
        if (!ManagerLobby.myLobby.getHost().equals(ManagerLobby.myPlayer))
            ManagerLobby.myLobby.getGame().addTurn(turn);
        else
            new StartTimerCommand().execute();
    }

    private void initCanvas() {
        new ClearCanvasCommand().execute();
    }

    private void initAnimation() {
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().drawString("3");
        getClip();
        sleep(1000);
        clearCanvas();
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().drawString("2");
        getClip();
        sleep(1000);
        clearCanvas();
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().drawString("1");
        getClip();
        sleep(1000);
        clearCanvas();
    }

    private void getClip() {
        new ClipSoundLoader().load().start();
    }

    private void sleep (int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clearCanvas () {
        new ClearCanvasCommand().execute();
    }

    private void initWordDisplay () {
        ManagerLobby.myLobbyFrame.getWordPanel().getWordDisplay().setVisible(true);
        ManagerLobby.myLobbyFrame.getWordPanel().refresh();
    }

    private void initChat () {
        new TypeChatCommand(new ChatMessage(new Player("Admin", "", Color.black), turn.getPlayer()+" va a dibujar")).execute();
    }
}
