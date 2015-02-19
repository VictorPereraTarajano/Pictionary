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
                        sendMessage();
                    }
                });
            }
        };
    }

    private void sendMessage () {
        if (ManagerLobby.myLobby.getGame() == null || !ManagerLobby.myLobby.getGame().getActualTurn().getPlayer().equals(ManagerLobby.myPlayer)) {
            if (ManagerLobby.myLobby.getGame() != null&& WordMatcher.match(new Word(getMessage()), ManagerLobby.myLobby.getGame().getActualTurn().getWord())) {
                ManagerLobby.myLobby.getScoring().add(ManagerLobby.myPlayer, new Score(ManagerLobby.myLobby.getScoring().getScore(ManagerLobby.myPlayer).getScore()+10));
                new SendMessageCommand(new SendScoringStateMessage(new SendScoringStateData(ManagerLobby.myLobby.getScoring())), ManagerConnection.TCPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers())).execute();
            } else {
                ManagerLobby.myLobby.getChat().add(new ChatMessage(ManagerLobby.myPlayer, getMessage()));
                new SendMessageCommand(new SendChatStateMessage(new SendChatStateData(ManagerLobby.myPlayer, getMessage())), ManagerConnection.TCPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers())).execute();
            }
            clear();
        }
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
                    sendMessage();
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
