package view.ui.viewers.impl.swing.wordpanel;


import view.ui.display.impl.swing.worddisplay.WordDisplay;

import javax.swing.*;
import java.awt.*;

public class WordPanel extends JPanel implements view.ui.viewers.interfaces.wordpanel.WordPanel {

    private WordDisplay wordDisplay;

    public WordPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Word Panel"));
        createWidgets();
    }

    private void createWidgets() {
        add(createWordDisplay());
    }

    private Component createWordDisplay() {
        wordDisplay = new WordDisplay();
        return wordDisplay;
    }

    @Override
    public void refresh() {

    }
}
