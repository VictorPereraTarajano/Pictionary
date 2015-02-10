package view.ui.viewers.interfaces;

import view.ui.dialog.interfaces.ChatDialog;
import view.ui.display.interfaces.ChatDisplay;

public interface ChatPanel {
    public ChatDialog getChatDialog();
    public ChatDisplay getChatDisplay();
}
