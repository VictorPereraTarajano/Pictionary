package view.ui.display.impl.swing;

import javax.swing.*;
import java.awt.*;

public class WordDisplay extends JPanel {
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
}
