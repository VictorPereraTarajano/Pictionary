package view.ui.viewers.impl.swing;

import view.ui.dialog.impl.swing.ChatDialog;
import view.ui.display.impl.swing.ChatDisplay;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChatPanel extends JPanel implements view.ui.viewers.interfaces.ChatPanel {

    private ChatDialog chatDialog;
    private ChatDisplay chatDisplay;
    private Color backgroundColor;

    public ChatPanel() {
        super();
        setBorder(new EmptyBorder(10,10,10,10));
        setLayout(new BorderLayout());
        createWidgets();
        setOpaque(false);
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
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(backgroundColor);
        g2d.fillRect(0,0,getSize().width,getSize().height);
        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(0, 0, this.getSize().width-5, this.getSize().height-5, 25, 25);
        super.paintComponent(g2d);
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

    public void setBackgroundColor(Color color) {
        chatDialog.setBackgroundColor(color);
        backgroundColor=color;
    }
}
