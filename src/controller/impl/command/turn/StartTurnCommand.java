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
        new EnableChatDialogCommand().execute();
        new DisableCanvasDisplayCommand().execute();
        ManagerLobby.myLobbyFrame.getWordPanel().getWordDisplay().setVisible(false);
        new HideCanvasOptionsDialogCommand().execute();
        new ShowReportPlayerDialogCommand().execute();
    }

    private void initPainterStuff() {
        new DisableChatDialogCommand().execute();
        new EnableCanvasDisplayCommand().execute();
        ManagerLobby.myLobbyFrame.getWordPanel().getWordDisplay().setVisible(true);
        new ShowCanvasOptionsDialogCommand().execute();
        new HideReportPlayerDialogCommand().execute();
    }

    private void initTurn() {
        if (!ManagerLobby.myLobby.getHost().equals(ManagerLobby.myPlayer))
            ManagerLobby.myLobby.getGame().addTurn(turn);
        else
            new StartTimerCommand().execute();
    }

    private void initAnimation() {
        for (int i = 3; i > 0; i--)
            drawNumber(String.valueOf(i));
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

    private void initWordDisplay () {
        ManagerLobby.myLobbyFrame.getWordPanel().refresh();
    }

    private void initChat () {
        new TypeChatCommand(new ChatMessage(new Player("Admin", "", Color.black), "<font color="+ ChatDisplay.getHexadecimalColor(turn.getPlayer().getColor())+">"+turn.getPlayer()+ " va a dibujar</font>")).execute();
    }
}
