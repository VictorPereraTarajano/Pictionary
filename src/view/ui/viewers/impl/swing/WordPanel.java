package view.ui.viewers.impl.swing;


import view.ui.display.impl.swing.WordDisplay;

import javax.swing.*;
import java.awt.*;

public class WordPanel extends JPanel implements view.ui.viewers.interfaces.WordPanel {

    private WordDisplay wordDisplay;
    private Color backgroundColor;

    public WordPanel() {
        super();
        setPreferredSize(new Dimension(10,42));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        createWidgets();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g2d.setColor(backgroundColor);
        g2d.fillRect(0, 0, this.getParent().getSize().width, getSize().height);
        g2d.setColor(Color.RED);
        g2d.setClip(10, 0, this.getParent().getSize().width-20, getSize().height/2);
        g2d.fillRoundRect(10, 0, this.getParent().getSize().width - 20, getSize().height / 2, 10, 10);
        g2d.setClip(null);
        g2d.setClip(10, 5, this.getParent().getSize().width-20, getSize().height);
        g2d.fillRect(10, 5, this.getParent().getSize().width-20, getSize().height);
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

    public void setBackgroundColor(Color color) {
        backgroundColor=color;
    }
}
