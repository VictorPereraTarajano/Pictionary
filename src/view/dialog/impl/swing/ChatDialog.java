package view.dialog.impl.swing;

import controller.impl.send.SendMessageCommand;
import model.message.impl.state.impl.SendChatStateMessage;
import model.message.impl.state.interfaces.SendStateMessage;
import model.message.messagedata.impl.statedata.impl.SendChatStateData;
import model.net.sender.impl.UDPSender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatDialog extends JPanel implements view.dialog.interfaces.ChatDialog {

    private static final int MAX_COLUMNS=20;
    private JTextField textField;
    private JButton acceptButton;

    public ChatDialog() {
        super();
        createWidgets();
    }

    private void createWidgets() {
        add(createTextField());
        add(createAcceptButton());
    }

    private Component createAcceptButton() {
        acceptButton=new JButton("ENVIAR");
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SendMessageCommand(new SendChatStateMessage(new SendChatStateData(getMessage())), new UDPSender(2000,"localhost")).execute();
                textField.setText("");
            }
        });
        return acceptButton;
    }

    private Component createTextField() {
        this.textField = new JTextField(MAX_COLUMNS);
        return textField;
    }

    @Override
    public String getMessage() {
        return textField.getText();
    }
}
