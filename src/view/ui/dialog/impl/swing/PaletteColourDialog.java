package view.ui.dialog.impl.swing;

import javax.swing.*;
import java.awt.*;

public class PaletteColourDialog extends JPopupMenu {

    public PaletteColourDialog(Point point) {
        super();
        setLocation(point.x, point.y);
        setPreferredSize(new Dimension(100,100));
        setBackground(Color.RED);
        setVisible(true);
    }
}
