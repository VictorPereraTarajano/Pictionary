package view.ui.viewers.interfaces;

import view.ui.display.interfaces.ChatDisplay;

public interface ChatPanel {
    public ChatDisplay getChatDisplay();
    public void refresh();
}
