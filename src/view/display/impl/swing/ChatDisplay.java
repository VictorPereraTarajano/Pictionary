package view.display.impl.swing;

import model.message.messagedata.impl.statedata.impl.SendChatStateData;

import javax.swing.*;
import java.awt.*;

public class ChatDisplay extends JPanel implements view.display.interfaces.ChatDisplay {

    private JTextArea textArea;
    private SendChatStateData chatData;

    public ChatDisplay(SendChatStateData chatData) {
        super();
        this.chatData=chatData;
        createWidgets();
    }

    private void createWidgets() {
        add(createTextArea());
    }

    private Component createTextArea() {
        textArea=new JTextArea();
        return textArea;
    }

    @Override
    public void display() {
        textArea.append(chatData.getMessage());
    }
}
