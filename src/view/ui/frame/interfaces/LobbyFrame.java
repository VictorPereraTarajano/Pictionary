package view.ui.frame.interfaces;

import view.ui.viewers.impl.swing.CanvasPanel;
import view.ui.viewers.impl.swing.ChatPanel;
import view.ui.viewers.impl.swing.ScoringPanel;

public interface LobbyFrame {
    public CanvasPanel getCanvasPanel();
    public ChatPanel getChatPanel();
    public ScoringPanel getScoringPanel();
}
