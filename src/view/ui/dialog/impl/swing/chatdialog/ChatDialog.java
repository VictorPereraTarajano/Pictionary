package view.ui.dialog.impl.swing.chatdialog;

import controller.impl.sendcommand.SendMessageCommand;
import model.message.impl.state.impl.SendChatStateMessage;
import model.messagedata.impl.statedata.impl.SendChatStateData;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChatDialog extends JPanel implements view.ui.dialog.interfaces.chatdialog.ChatDialog {

    private static final int MAX_COLUMNS=24;
    private JTextField textField;

    public ChatDialog() {
        super();
        createWidgets();
    }

    private void createWidgets() {
        add(createTextField());
        add(createAcceptButton());
    }

    private Component createAcceptButton() {
        return new JButton("SEND") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new SendMessageCommand(new SendChatStateMessage(new SendChatStateData(ManagerLobby.myPlayer, getMessage())), ManagerConnection.TCPBroadcast(ManagerLobby.myLobbyFrame.getLobby().getScoring().getPlayers())).execute();
                        clear();
                    }
                });
            }
        };
    }

    private void clear () {
        textField.setText("");
    }

    private Component createTextField() {
        textField = new JTextField(MAX_COLUMNS);
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar()=='\n'){
                    new SendMessageCommand(new SendChatStateMessage(new SendChatStateData(ManagerLobby.myLobbyFrame.getLobby().getScoring().getPlayers()[0], getMessage())), ManagerConnection.TCPBroadcast(ManagerLobby.myLobbyFrame.getLobby().getScoring().getPlayers())).execute();
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
