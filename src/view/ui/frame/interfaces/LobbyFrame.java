package view.ui.frame.interfaces;

import view.ui.viewers.impl.swing.CanvasPanel;
import view.ui.viewers.impl.swing.ChatPanel;
import view.ui.viewers.impl.swing.ScoringPanel;
import view.ui.viewers.interfaces.TimerPanel;
import view.ui.viewers.interfaces.WordPanel;

public interface LobbyFrame {
    public CanvasPanel getCanvasPanel();
    public ChatPanel getChatPanel();
    public ScoringPanel getScoringPanel();
    public TimerPanel getTimerPanel();
    public WordPanel getWordPanel();
}
