package view.ui.dialog.impl.swing;

import controller.impl.sendcommand.SendMessageCommand;
import model.message.impl.state.impl.SendChatStateMessage;
import model.messagedata.impl.statedata.impl.SendChatStateData;
import model.net.manager.ManagerConnection;
import view.ui.frame.impl.swing.LobbyFrame;
import view.ui.frame.managerlobby.ManagerLobby;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChatDialog extends JPanel implements view.ui.dialog.interfaces.ChatDialog {

    private static final int MAX_COLUMNS=24;
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
                ManagerLobby.myLobbyFrame.getChatPanel().getChatDisplay().display(new SendChatStateData(LobbyFrame.myPlayer, getMessage()));
                new SendMessageCommand(new SendChatStateMessage(new SendChatStateData(LobbyFrame.myPlayer, getMessage())), ManagerConnection.TCPBroadcast(ManagerLobby.myLobbyFrame.getLobby().getPlayerSet().toArray())).execute();
                clear();
            }
        });
        return acceptButton;
    }

    private void clear () {
        textField.setText("");
    }

    private Component createTextField() {
        this.textField = new JTextField(MAX_COLUMNS);
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar()=='\n'){
                    //ManagerLobby.myLobbyFrame.getChatPanel().getChatDisplay().display(new SendChatStateData(LobbyFrame.myPlayer, getMessage()));
                    new SendMessageCommand(new SendChatStateMessage(new SendChatStateData(LobbyFrame.myPlayer, getMessage())), ManagerConnection.TCPBroadcast(ManagerLobby.myLobbyFrame.getLobby().getPlayerSet().toArray())).execute();
                    clear();
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
