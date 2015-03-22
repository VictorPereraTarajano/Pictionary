package controller.impl.command.popups.reportplayer;

import controller.interfaces.Command;
import view.ui.display.impl.swing.ReportPlayerDisplay;

public class ShowReportPlayerDisplayCommand implements Command {

    @Override
    public void execute() {
        new ReportPlayerDisplay();
    }
}
