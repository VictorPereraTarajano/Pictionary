package controller.impl.command.results;

import controller.impl.command.frame.canvas.HideCanvasPanelCommand;
import controller.impl.command.frame.results.ShowResultsPanelCommand;
import controller.impl.command.frame.timer.HideTimerPanelCommand;
import controller.impl.command.frame.word.HideWordPanelCommand;
import controller.interfaces.Command;

public class ShowResultsCommand implements Command {
    @Override
    public void execute() {
        new HideCanvasPanelCommand().execute();
        new HideWordPanelCommand().execute();
        new HideTimerPanelCommand().execute();
        new ShowResultsPanelCommand().execute();
    }
}
