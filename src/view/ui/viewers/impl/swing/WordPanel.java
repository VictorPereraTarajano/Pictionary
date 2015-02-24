package view.ui.viewers.impl.swing;


import view.ui.display.impl.swing.WordDisplay;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WordPanel extends JPanel implements view.ui.viewers.interfaces.WordPanel {

    private WordDisplay wordDisplay;

    public WordPanel() {
        super();
        setBorder(new EmptyBorder(10,10,10,10));
        createWidgets();
        setBackground(new Color(250,56,56));
    }

    private void createWidgets() {
        add(createWordDisplay());
    }

    private Component createWordDisplay() {
        wordDisplay = new WordDisplay();
        return wordDisplay;
    }

    public WordDisplay getWordDisplay() {
        return wordDisplay;
    }

    @Override
    public void refresh() {
        wordDisplay.display();
    }
}
