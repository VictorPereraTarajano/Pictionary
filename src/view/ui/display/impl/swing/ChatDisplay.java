package view.ui.display.impl.swing;

import model.messagedata.impl.statedata.impl.SendChatStateData;

import javax.swing.*;
import java.awt.*;

public class ChatDisplay extends JPanel implements view.ui.display.interfaces.ChatDisplay {

    private static final int NUM_ROWS=30, NUM_COLUMNS=35;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    public ChatDisplay(){
        super();
        createWidgets();
    }

    private void createWidgets() {
        add(createTextArea());
        add(createScrollPane());
    }

    private Component createScrollPane() {
        scrollPane=new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
    }

    private Component createTextArea() {
        textArea=new JTextArea(NUM_COLUMNS,NUM_ROWS);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        return textArea;
    }

    @Override
    public void display(SendChatStateData sendChatStateData) {
        textArea.append(sendChatStateData.getPlayer().getName()+" : "+sendChatStateData.getMessage()+"\n");
    }
}
