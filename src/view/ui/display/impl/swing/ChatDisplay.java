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
    }

    private void createWidgets() {
        add(createTextArea());
        add(createScrollPane());
    }

    private Component createScrollPane() {
        return new JScrollPane(textArea) {
            {
                setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            }
        };
    }

    private Component createTextArea() {
        textArea=new JTextPane() {

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.drawImage(createImage(this.getSize().width, this.getSize().height),0,0,Color.blue, null);
                super.paintComponent(g2d);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(ManagerLobby.myLobbyFrame.getChatPanel().getSize().width,ManagerLobby.myLobbyFrame.getChatPanel().getSize().height - ManagerLobby.myLobbyFrame.getChatPanel().getChatDialog().getSize().height);
            }
        };
        textArea.setOpaque(false);
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
