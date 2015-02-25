package view.ui.viewers.impl.swing;

import view.ui.dialog.impl.swing.ChatDialog;
import view.ui.display.impl.swing.ChatDisplay;

import javax.swing.*;
import java.awt.*;

public class ChatPanel extends JPanel implements view.ui.viewers.interfaces.ChatPanel {

    private ChatDialog chatDialog;
    private ChatDisplay chatDisplay;

    public ChatPanel() {
        super();
        setBorder(null);
        setLayout(new BorderLayout());
        createWidgets();
    }

    private void createWidgets() {
        add(createChatDisplay(), BorderLayout.CENTER);
        add(createChatDialog(), BorderLayout.SOUTH);
    }

    private Component createChatDialog() {
        chatDialog = new ChatDialog();
        return chatDialog;
    }

    private Component createChatDisplay() {
        chatDisplay = new ChatDisplay();
        return chatDisplay;
    }

    @Override
    public ChatDialog getChatDialog() {
        return chatDialog;
    }

    @Override
    public ChatDisplay getChatDisplay() {
        return chatDisplay;
    }

    @Override
    public void refresh() {
        chatDisplay.display();
    }

}
