package view.ui.display.impl.swing;

import model.manager.ManagerLobby;

import javax.swing.*;
import java.awt.*;

public class WordDisplay extends JPanel implements view.ui.display.interfaces.WordDisplay {

    private JLabel word;

    public WordDisplay() {
        super();
        createWidgets();
    }

    private void createWidgets() {
        add(createWordLabel());
    }

    private Component createWordLabel() {
        word=new JLabel();
        return word;
    }

    public void clear () {
        word.setText("");
    }

    @Override
    public void display() {
        if (!ManagerLobby.myLobby.getGame().currentTurn().getPlayer().equals(ManagerLobby.myPlayer)) {
            for (int i = 0; i < ManagerLobby.myLobby.getGame().currentTurn().getWord().getWord().length(); i++) {
                word.setText(word.getText() + " _");
            }
        } else {
            word.setText(ManagerLobby.myLobby.getGame().currentTurn().getWord().getWord());
        }
    }
}
