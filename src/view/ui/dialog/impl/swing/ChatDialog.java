package view.ui.dialog.impl.swing;

import controller.impl.sendcommand.SendMessageCommand;
import model.chat.ChatMessage;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.scoring.Score;
import model.statemessage.impl.SendChatStateMessage;
import model.statemessage.impl.SendScoringStateMessage;
import model.statemessagedata.impl.SendChatStateData;
import model.statemessagedata.impl.SendScoringStateData;
import model.word.Word;
import view.process.WordMatcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChatDialog extends JPanel implements view.ui.dialog.interfaces.ChatDialog {

    private static final int MAX_COLUMNS=27;
    private JTextField textField;

    public ChatDialog() {
        super();
        setLayout(new BorderLayout());
        createWidgets();
        setBackground(new Color(250,56,56));
    }

    private void createWidgets() {
        add(createTextField(), BorderLayout.WEST);
        add(createAcceptButton(), BorderLayout.EAST);
    }

    private Component createAcceptButton() {
        return new JButton("SEND") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sendMessage();
                    }
                });
            }
        };
    }

    private void sendMessage () {
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
    }

    private void clear () {
        textField.setText("");
    }

    private Component createTextField() {
        textField = new JTextField(MAX_COLUMNS) {
            {
                setPreferredSize(new Dimension(100,30));
            }
        };
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar()=='\n') sendMessage();
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
