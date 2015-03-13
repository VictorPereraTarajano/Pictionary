package view.ui.display.impl.swing;

import model.chat.ChatMessage;
import model.manager.ManagerLobby;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class ChatDisplay extends JPanel implements view.ui.display.interfaces.ChatDisplay {

    private JTextPane textArea;

    public ChatDisplay(){
        super();
        setLayout(new BorderLayout());
        createWidgets();
    }

    private void createWidgets() {
        add(createChatLabel(), BorderLayout.NORTH);
        add(createTextArea(), BorderLayout.CENTER);
        add(createScrollPane());
    }


    private Component createChatLabel() {
        return new JLabel(" Chat"){

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, getSize().width, getSize().height);
                g2d.setColor(new Color(225,218,89));
                g2d.fillRoundRect(0, 0, getSize().width, getSize().height, 10, 10);
                g2d.setColor(new Color(178,172,64));
                g2d.drawRoundRect(0, 0, getSize().width, getSize().height, 10, 10);
                super.paintComponent(g2d);
            }
        };
    }

    private Component createScrollPane() {
        return new JScrollPane(textArea) {
            {
                setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
                this.setBorder(null);
            }

        };
    }

    private Component createTextArea() {
        textArea=new JTextPane() {
            {
                setAutoscrolls(true);
                DefaultCaret caret = (DefaultCaret)getCaret();
                caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
            }
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, getSize().width, getSize().height);
                super.paintComponent(g2d);
            }

        };
        textArea.setEditable(false);
        return textArea;
    }

    public void clear () {
        textArea.setText("");
    }

    @Override
    public void display(ChatMessage message) {
        StyledDocument d = textArea.getStyledDocument();
        SimpleAttributeSet aatrs = new SimpleAttributeSet();
        if (ManagerLobby.myLobby.getChat().isEmpty())
            textArea.setText("");
        else {
            StyleConstants.setForeground(aatrs, ManagerLobby.myLobby.getChat().getLastMessage().getPlayer().getColor());
            try {
                d.insertString(d.getLength(), ManagerLobby.myLobby.getChat().getLastMessage().getPlayer().getName() + " : ", aatrs);
                d.insertString(d.getLength(), ManagerLobby.myLobby.getChat().getLastMessage().getMessage() + "\n", null);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }

}
