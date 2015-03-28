package controller.impl.command.results;

import controller.impl.command.frame.canvas.HideCanvasPanelCommand;
import controller.impl.command.frame.results.ShowResultsPanelCommand;
import controller.impl.command.frame.timer.HideTimerPanelCommand;
import controller.interfaces.Command;
import model.manager.ManagerLobby;
import model.scoring.Scoring;

public class ShowResultsCommand implements Command {

    private Scoring scoring;

    public ShowResultsCommand(Scoring scoring) {
        this.scoring = scoring;
    }

    @Override
    public void execute() {
        ManagerLobby.myLobby.setScoring(scoring);
        ManagerLobby.myLobbyFrame.getResultsPane().refresh();
        new HideCanvasPanelCommand().execute();
        new HideTimerPanelCommand().execute();
        new ShowResultsPanelCommand().execute();
    }
}
