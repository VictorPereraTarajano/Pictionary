package view.viewers.impl.swing;

import javax.swing.*;
import java.awt.*;

public class CanvasPanel extends JPanel {

    public CanvasPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Canvas Panel"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(), getHeight());
    }
}
