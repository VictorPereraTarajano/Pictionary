package view.ui.viewers.interfaces;

import model.chat.ChatMessage;
import view.ui.dialog.impl.swing.ChatDialog;
import view.ui.display.interfaces.ChatDisplay;

public interface ChatPanel {
    public ChatDisplay getChatDisplay();
    public ChatDialog getChatDialog();
    public void refresh(ChatMessage message);
}
