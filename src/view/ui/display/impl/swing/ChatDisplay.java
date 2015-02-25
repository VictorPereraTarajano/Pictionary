package view.ui.display.impl.swing;

import model.manager.ManagerLobby;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class ChatDisplay extends JPanel implements view.ui.display.interfaces.ChatDisplay {

    private JTextPane textArea;

    public ChatDisplay(){
        super();
        createWidgets();
        setBackground(new Color(250,56,56));
    }

    private void createWidgets() {
        add(createTextArea());
        add(createScrollPane());
    }

    private Component createScrollPane() {
        return new JScrollPane(textArea) {
            {
                setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                setBorder(null);
            }

        };
    }

    private Component createTextArea() {
        textArea=new JTextPane() {
            {
                setBorder(null);
                setPreferredSize(new Dimension(500,500));
            }
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                super.paintComponent(g2d);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(250, 56, 56));
                g2d.fillRect(0,0,getSize().width,getSize().height);
                g2d.setColor(Color.GRAY);
                g2d.fillRoundRect(0, 0, this.getSize().width, this.getSize().height, 25, 25);
                super.paintComponent(g2d);
            }
        };
        textArea.setEditable(false);
        return textArea;
    }

    @Override
    public void display() {
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
