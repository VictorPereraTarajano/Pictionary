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
        for(int i = 0; i < ManagerLobby.myLobby.getGame().getActualTurn().getWord().getWord().length(); i++) {
            word.setText(word.getText()+" _");
        }
    }


}
