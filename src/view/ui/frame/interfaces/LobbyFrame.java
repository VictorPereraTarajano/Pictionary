package view.ui.frame.interfaces;

import view.ui.viewers.impl.swing.canvaspanel.CanvasPanel;
import view.ui.viewers.impl.swing.chatpanel.ChatPanel;
import view.ui.viewers.impl.swing.scoringpanel.ScoringPanel;
import view.ui.viewers.interfaces.timerpanel.TimerPanel;
import view.ui.viewers.interfaces.wordpanel.WordPanel;

public interface LobbyFrame {
    public CanvasPanel getCanvasPanel();
    public ChatPanel getChatPanel();
    public ScoringPanel getScoringPanel();
    public TimerPanel getTimerPanel();
    public WordPanel getWordPanel();
    public void refresh();
}
