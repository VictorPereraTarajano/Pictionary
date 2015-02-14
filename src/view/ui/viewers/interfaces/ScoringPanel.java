package view.ui.viewers.interfaces;

import view.ui.display.interfaces.ScoringDisplay;

public interface ScoringPanel {
    public ScoringDisplay []  getScoringDisplay ();
    public void refresh();
}
