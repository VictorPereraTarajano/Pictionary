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

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class StartTurnCommand implements Command {

    private Turn turn;

    public StartTurnCommand(Turn turn) {
        this.turn = turn;
    }

    @Override
    public void execute() {
        initChat();
         if (ManagerLobby.myPlayer.equals(turn.getPlayer())) {
             ManagerLobby.myLobbyFrame.getChatPanel().getChatDialog().setEditable(false);
             ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().setEditable(true);
         } else {
             ManagerLobby.myLobbyFrame.getChatPanel().getChatDialog().setEditable(true);
             ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().setEditable(false);
         }
        initAnimation();
        if (!ManagerLobby.myLobby.getHost().equals(ManagerLobby.myPlayer))
            ManagerLobby.myLobby.getGame().addTurn(turn);
        else
            initTimer();
        initWordDisplay();
    }

    private void initAnimation() {
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().drawString("3");
        sound();
        sleep(1000);
        clearCanvas();
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().drawString("2");
        sound();
        sleep(1000);
        clearCanvas();
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().drawString("1");
        sound();
        sleep(1000);
        clearCanvas();
    }

    private void sound() {
        Clip sound = null;
        try {
            sound = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            sound.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\Victor\\IdeaProjects\\Pictionary\\res\\sound\\sonido.wav")));
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sound.start();
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

    private void initTimer () {
        new StopTimerCommand().execute();
        new StartTimerCommand().execute();
    }

    private void initChat () {
        new TypeChatCommand(new ChatMessage(new Player("Admin", "", Color.black), turn.getPlayer()+" va a dibujar")).execute();
    }
}
