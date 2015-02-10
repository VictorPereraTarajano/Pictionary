package view.viewers;


import model.message.messagedata.impl.statedata.impl.SendChatStateData;
import view.dialog.impl.swing.ChatDialog;
import view.display.impl.swing.ChatDisplay;

import javax.swing.*;
import java.awt.*;

public class ChatPanel extends JPanel {

    private ChatDialog chatDialog;
    private ChatDisplay chatDisplay;

    public ChatPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Chat Panel"));
        setLayout(new GridLayout(2,1));
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
        chatDisplay = new ChatDisplay(new SendChatStateData("Inicio de sesión"));
        return chatDisplay;
    }

}
