package view.ui.dialog.impl.swing;

import controller.impl.command.chat.TypeChatCommand;
import controller.impl.sendcommand.SendMessageCommand;
import model.chat.ChatMessage;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChatDialog extends JPanel implements view.ui.dialog.interfaces.ChatDialog {

    private static final int MAX_COLUMNS=27;
    private JTextField textField;

    public ChatDialog() {
        super();
        setLayout(new BorderLayout());
        createWidgets();
    }

    private void createWidgets() {
        add(createTextField(), BorderLayout.CENTER);
    }

    /*private void sendMessage () {
        if (ManagerLobby.myLobby.getGame() == null || !ManagerLobby.myLobby.getGame().currentTurn().getPlayer().equals(ManagerLobby.myPlayer)) {
            if (ManagerLobby.myLobby.getGame() != null && WordMatcher.match(new Word(getMessage()), ManagerLobby.myLobby.getGame().currentTurn().getWord())) {
                ManagerLobby.myLobbyFrame.getChatPanel().getChatDialog().setEditable(false);
                ManagerLobby.myLobbyFrame.getWordPanel().getWordDisplay().setVisible(true);
                ManagerLobby.myLobby.getScoring().add(ManagerLobby.myPlayer, new Score(ManagerLobby.myLobby.getScoring().getScore(ManagerLobby.myPlayer).getScore() + 10));
                new SendMessageCommand(new SendScoringStateMessage(new SendScoringStateData(ManagerLobby.myLobby.getScoring())), ManagerConnection.TCPBroadcast()).execute();
            } else {
                new SendMessageCommand(new SendChatStateMessage(new SendChatStateData(new ChatMessage(ManagerLobby.myPlayer, getMessage()))), ManagerConnection.TCPBroadcast()).execute();
            }
            clear();
        }
    }*/

    public void clear() {
        textField.setText("");
    }

    private Component createTextField() {
        textField = new JTextField(MAX_COLUMNS) {
            {
                setBorder(BorderFactory.createLineBorder(new Color(173,172,159)));
                setBackground(new Color(217,216,196));
            }
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300,20);
            }
        };
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar()=='\n') {
                    new SendMessageCommand(new TypeChatCommand(new ChatMessage(ManagerLobby.myPlayer, getMessage())), ManagerConnection.TCPBroadcastAll()).execute();
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

    public void setEditable(boolean editable) {
        textField.setEnabled(editable);
    }

}
