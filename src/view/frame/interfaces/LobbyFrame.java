package view.frame.interfaces;

import view.viewers.impl.swing.CanvasPanel;
import view.viewers.impl.swing.ChatPanel;
import view.viewers.impl.swing.ScoringPanel;

public interface LobbyFrame {
    public CanvasPanel getCanvasPanel();
    public ChatPanel getChatPanel();
    public ScoringPanel getScoringPanel();
}
