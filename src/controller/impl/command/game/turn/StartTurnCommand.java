package controller.impl.command.game.turn;

import controller.impl.command.canvas.ClearCanvasCommand;
import controller.impl.command.chat.TypeChatCommand;
import controller.impl.command.popups.canvas.canvasoptions.HideCanvasOptionsDialog;
import controller.impl.command.popups.canvas.canvasoptions.ShowCanvasOptionsDialog;
import controller.impl.command.popups.canvas.reportplayer.HideReportPlayerDialog;
import controller.impl.command.popups.canvas.reportplayer.ShowReportPlayerDialog;
import controller.impl.command.timer.StartTimerCommand;
import controller.interfaces.Command;
import model.chat.ChatMessage;
import model.game.Turn;
import model.manager.ManagerLobby;
import model.player.Player;
import view.persistence.impl.loaders.clip.FactoryClipLoader;
import view.ui.display.impl.swing.ChatDisplay;

import java.awt.*;

public class StartTurnCommand implements Command {

    private Turn turn;

    public StartTurnCommand(Turn turn) {
        this.turn = turn;
    }

    @Override
    public void execute() {
        initChat();
        initStuff();
        initAnimation();
        initWordDisplay();
        initTurn();
    }

    private void initStuff() {
        if (ManagerLobby.myPlayer.equals(turn.getPlayer()))
            initPainterStuff();
        else
            initNonPainterStuff();
    }

    private void initNonPainterStuff() {
        ManagerLobby.myLobbyFrame.getChatPanel().getChatDialog().setEditable(true);
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().setEditable(false);
        ManagerLobby.myLobbyFrame.getWordPanel().getWordDisplay().setVisible(false);
        new HideCanvasOptionsDialog().execute();
        new ShowReportPlayerDialog().execute();
    }

    private void initPainterStuff() {
        ManagerLobby.myLobbyFrame.getChatPanel().getChatDialog().setEditable(false);
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().setEditable(true);
        ManagerLobby.myLobbyFrame.getWordPanel().getWordDisplay().setVisible(true);
        new ShowCanvasOptionsDialog().execute();
        new HideReportPlayerDialog().execute();
    }

    private void initTurn() {
        if (!ManagerLobby.myLobby.getHost().equals(ManagerLobby.myPlayer))
            ManagerLobby.myLobby.getGame().addTurn(turn);
        else
            new StartTimerCommand().execute();
    }

    private void initAnimation() {
        clearCanvas();
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
        FactoryClipLoader.START_TURN.start();
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
        ManagerLobby.myLobbyFrame.getWordPanel().refresh();
    }

    private void initChat () {
        new TypeChatCommand(new ChatMessage(new Player("Admin", "", Color.black), "<font color="+ ChatDisplay.getHexadecimalColor(turn.getPlayer().getColor())+">"+turn.getPlayer()+ " va a dibujar</font>")).execute();
    }
}
