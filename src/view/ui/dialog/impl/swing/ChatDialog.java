package view.ui.dialog.impl.swing;

import controller.impl.sendcommand.SendMessageCommand;
import model.message.impl.state.impl.SendChatStateMessage;
import model.messagedata.impl.statedata.impl.SendChatStateData;
import model.net.sender.impl.UDPSender;
import model.player.Player;
import view.ui.frame.impl.swing.LobbyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChatDialog extends JPanel implements view.ui.dialog.interfaces.ChatDialog {

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
        acceptButton= new JButton("SEND");
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SendMessageCommand(new SendChatStateMessage(new SendChatStateData(LobbyFrame.myPlayer, getMessage())), new UDPSender(2000,"localhost")).execute();
                textField.setText("");
            }
        });
        return acceptButton;
    }

    private Component createTextField() {
        this.textField = new JTextField(MAX_COLUMNS);
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar()=='\n'){
                    new SendMessageCommand(new SendChatStateMessage(new SendChatStateData(LobbyFrame.myPlayer, getMessage())), new UDPSender(2000,"localhost")).execute();
                    textField.setText("");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        return textField;
    }

    @Override
    public String getMessage() {
        return textField.getText();
    }
}
