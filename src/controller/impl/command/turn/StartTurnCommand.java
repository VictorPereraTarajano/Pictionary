package controller.impl.command.turn;

import controller.impl.command.canvas.ClearCanvasCommand;
import controller.impl.command.chat.TypeChatCommand;
import controller.impl.command.editable.canvas.DisableCanvasDisplayCommand;
import controller.impl.command.editable.canvas.EnableCanvasDisplayCommand;
import controller.impl.command.editable.chat.DisableChatDialogCommand;
import controller.impl.command.editable.chat.EnableChatDialogCommand;
import controller.impl.command.popups.canvasoptions.HideCanvasOptionsDialogCommand;
import controller.impl.command.popups.canvasoptions.ShowCanvasOptionsDialogCommand;
import controller.impl.command.popups.reportplayer.HideReportPlayerDialogCommand;
import controller.impl.command.popups.reportplayer.ShowReportPlayerDialogCommand;
import controller.impl.command.timer.StartTimerCommand;
import controller.impl.command.timer.StopTimerCommand;
import controller.impl.command.word.HideWordDisplayCommand;
import controller.impl.command.word.ShowCodifiedWordCommand;
import controller.impl.command.word.ShowDecodifiedWordCommand;
import controller.impl.command.word.ShowWordDisplayCommand;
import controller.interfaces.Command;
import model.chat.ChatMessage;
import model.game.Game;
import model.game.Turn;
import model.manager.ManagerGame;
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
        if (ManagerLobby.myPlayer.equals(ManagerLobby.myLobby.getHost())) resetTimer();
        initChat();
        initTurn();
        initStuff();
        clearWordDisplay();
        initAnimation();
        showWordDisplay();
        if (ManagerLobby.myLobby.getHost().equals(ManagerLobby.myPlayer)) new StartTimerCommand().execute();
    }

    private void resetTimer() {
        new StopTimerCommand().execute();
    }

    private void showWordDisplay() {
        new ShowWordDisplayCommand().execute();
    }

    private void initStuff() {
        if (ManagerGame.isPainter(ManagerLobby.myPlayer))
            initPainterStuff();
        else
            initNonPainterStuff();
    }

    private void initNonPainterStuff() {
        new EnableChatDialogCommand().execute();
        new DisableCanvasDisplayCommand().execute();
        new ShowCodifiedWordCommand().execute();
        new HideCanvasOptionsDialogCommand().execute();
        new ShowReportPlayerDialogCommand().execute();
    }

    private void initPainterStuff() {
        new DisableChatDialogCommand().execute();
        new EnableCanvasDisplayCommand().execute();
        new ShowDecodifiedWordCommand().execute();
        new ShowCanvasOptionsDialogCommand().execute();
        new HideReportPlayerDialogCommand().execute();
    }

    private void initTurn() {
        if (!ManagerLobby.myLobby.getHost().equals(ManagerLobby.myPlayer)) {
            if (ManagerLobby.myLobby.getGame() == null)
                ManagerLobby.myLobby.setGame(new Game());
            ManagerLobby.myLobby.getGame().addTurn(turn);
        }
    }

    private void initAnimation() {
        for (int i = 3; i > 0; i--)
            drawNumber(String.valueOf(i));
        clearCanvas();
    }

    private void drawNumber(String number) {
        clearCanvas();
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().drawString(number);
        getClip();
        sleep(1000);
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

    private void clearWordDisplay() {
        new HideWordDisplayCommand().execute();
    }

    private void initChat () {
        new TypeChatCommand(new ChatMessage(new Player("Admin", "", Color.black), "<font color="+ ChatDisplay.getHexadecimalColor(turn.getPlayer().getColor())+">"+turn.getPlayer()+ " va a dibujar</font>")).execute();
    }
}
