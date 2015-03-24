package view.ui.display.impl.swing;

import model.manager.ManagerLobby;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WordDisplay extends JPanel implements view.ui.display.interfaces.WordDisplay {

    private JLabel word;
    private boolean visible=false;

    public WordDisplay() {
        super();
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(0,20,0,20));
        createWidgets();
        setVisible(false);
    }

    private void createWidgets() {
        add(createWordLabel(), BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (visible) {
            super.paintComponent(g2d);
            g2d.setColor(new Color(244, 40, 40));
            g2d.fillRect(0, 0, getLayout().minimumLayoutSize(this).width, getLayout().minimumLayoutSize(this).height);
            g2d.setColor(new Color(119, 31, 31));
            g2d.fillRoundRect(0, 0, getLayout().minimumLayoutSize(this).width, getLayout().minimumLayoutSize(this).height, 10, 10);
        }
    }

    private Component createWordLabel() {
        return word=new JLabel() {
            {
                setForeground(new Color(221,224,31));
                setFont(new Font("Montserrat", Font.BOLD, 19));
            }
        };
    }

    public void clear () {
        word.setText("");
    }

    private void showCodifiedWord () {
        for (int i = 0; i < ManagerLobby.myLobby.getGame().currentTurn().getWord().getVisibleWord().length(); i++)
            word.setText(word.getText() + " _");
    }

    private void showWord () {
        word.setText(ManagerLobby.myLobby.getGame().currentTurn().getWord().getVisibleWord());
    }

    @Override
    public void display() {
        if (visible)
            showWord();
        else
            showCodifiedWord();
        setVisible(true);
    }

    public void enableVisibility (boolean visible) {
        this.visible=visible;
    }

}
