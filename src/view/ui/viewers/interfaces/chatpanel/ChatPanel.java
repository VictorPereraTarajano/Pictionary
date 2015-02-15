package view.ui.viewers.interfaces.chatpanel;

import view.ui.display.interfaces.chatdisplay.ChatDisplay;

public interface ChatPanel {
    public ChatDisplay getChatDisplay();
    public void refresh();
}
