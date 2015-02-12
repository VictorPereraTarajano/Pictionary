package view.ui.dialog.impl.swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CanvasDialog extends JPanel implements view.ui.dialog.interfaces.CanvasDialog {

    private static final int WIDTH=600, HEIGHT=100;

    private JButton clearButton;

    public CanvasDialog() {
        super();
        setBorder(BorderFactory.createTitledBorder("Canvas Options"));
        createWidgets();
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(WIDTH,HEIGHT);
    }

    private void createWidgets() {
        add(createClearButton());
    }

    private Component createClearButton() {
        clearButton=new JButton("CLEAR");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        return clearButton;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Point getPoint() {
        return null;
    }

    @Override
    public boolean getClearOption() {
        return false;
    }

    @Override
    public Color getColor() {
        return null;
    }
}
