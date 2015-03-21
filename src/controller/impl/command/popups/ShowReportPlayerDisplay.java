package controller.impl.command.popups;

import controller.interfaces.Command;
import view.ui.display.impl.swing.ReportPlayerDisplay;

public class ShowReportPlayerDisplay implements Command {

    @Override
    public void execute() {
        new ReportPlayerDisplay();
    }
}
