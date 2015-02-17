package view.ui.viewers.impl.swing.chatpanel;

import view.ui.dialog.impl.swing.chatdialog.ChatDialog;
import view.ui.display.impl.swing.chatdisplay.ChatDisplay;
import javax.swing.*;
import java.awt.*;

public class ChatPanel extends JPanel implements view.ui.viewers.interfaces.chatpanel.ChatPanel {

    private ChatDialog chatDialog;
    private ChatDisplay chatDisplay;

    public ChatPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Chat Panel"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        createWidgets();
    }

    private void createWidgets() {
        add(createChatDisplay());
        add(createChatDialog());
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
    public ChatDisplay getChatDisplay() {
        return chatDisplay;
    }

    @Override
    public void refresh() {
        chatDisplay.display();
    }

}
