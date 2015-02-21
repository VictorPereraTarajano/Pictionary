package view.ui.display.impl.swing;

import model.manager.ManagerLobby;
import view.ui.frame.impl.swing.LobbyFrame;

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
            {

            }
            @Override
            public Dimension getPreferredSize() {
                LobbyFrame panel = (LobbyFrame) getTopLevelAncestor();
                return new Dimension(panel.getChatPanel().getSize().width-20,panel.getChatPanel().getSize().height/2 + panel.getChatPanel().getSize().height/4);
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
