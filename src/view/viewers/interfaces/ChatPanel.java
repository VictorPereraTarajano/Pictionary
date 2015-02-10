package view.viewers.interfaces;

import view.dialog.interfaces.ChatDialog;
import view.display.interfaces.ChatDisplay;

public interface ChatPanel {
    public ChatDialog getChatDialog();
    public ChatDisplay getChatDisplay();
}
