package view.ui.display.impl.swing;

import model.manager.ManagerLobby;

import javax.swing.*;
import java.awt.*;

public class WordDisplay extends JPanel implements view.ui.display.interfaces.WordDisplay {

    private JLabel word;
    private boolean visible=false;

    public WordDisplay() {
        super();
        createWidgets();
        setBackground(new Color(250,56,56));
    }

    private void createWidgets() {
        add(createWordLabel());
    }

    private Component createWordLabel() {
        return word=new JLabel() {
            {
                setForeground(Color.YELLOW);
                setFont(new Font("Montserrat", Font.BOLD, 25));
            }
        };
    }

    public void clear () {
        word.setText("");
    }

    private void showCodifiedWord () {
        for (int i = 0; i < ManagerLobby.myLobby.getGame().currentTurn().getWord().getWord().length(); i++) word.setText(word.getText() + " _");
    }

    private void showWord () {
        word.setText(ManagerLobby.myLobby.getGame().currentTurn().getWord().getWord());
    }

    @Override
    public void display() {
        if (visible)
            showWord();
        else
            showCodifiedWord();
    }

    public void setVisible(boolean visible) {
        this.visible=visible;
    }

}
