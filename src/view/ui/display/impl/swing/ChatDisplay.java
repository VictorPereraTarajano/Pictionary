package view.ui.display.impl.swing;

import model.manager.ManagerLobby;

import javax.swing.*;
import java.awt.*;

public class ChatDisplay extends JPanel implements view.ui.display.interfaces.ChatDisplay {

    private static final int NUM_ROWS=30, NUM_COLUMNS=35;
    private JTextArea textArea;

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
        textArea=new JTextArea(NUM_COLUMNS,NUM_ROWS);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        return textArea;
    }

    @Override
    public void display() {
        if (ManagerLobby.myLobby.getChat().isEmpty())
            textArea.setText("");
        else
            textArea.append(ManagerLobby.myLobby.getChat().getLastMessage().getPlayer().getName()+" : "+ManagerLobby.myLobby.getChat().getLastMessage().getMessage()+"\n");
    }
}
