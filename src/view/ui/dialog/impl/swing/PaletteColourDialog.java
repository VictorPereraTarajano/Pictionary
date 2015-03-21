package view.ui.dialog.impl.swing;

import controller.impl.command.pencil.HidePencilCommand;
import controller.impl.command.pencil.options.UpdatePencilColorCommand;
import controller.impl.command.popups.canvas.palette.HidePaletteColourDialog;
import controller.impl.sendcommand.SendCommand;
import model.manager.ManagerConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PaletteColourDialog extends JPopupMenu {

    private final int tiles_width = 18;
    private final int tiles_height = 12;

    public PaletteColourDialog() {
        super();
        setPreferredSize(new Dimension(tiles_width * 12, tiles_height * 12));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder());
        setLayout(new GridLayout(tiles_height, tiles_width));
        createPalette();
    }

    private void createPalette() {
        for (int i = 0; i < tiles_width*tiles_height; i++) {
            add(new TileColor(new Color((i)%255, (i*3)%255, (i*6)%255)) {
                {
                    addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {

                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
                            new SendCommand(new UpdatePencilColorCommand(((TileColor)e.getSource()).getColor()), ManagerConnection.TCPBroadcastAll()).execute();
                            new HidePaletteColourDialog().execute();
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                            new UpdatePencilColorCommand(((TileColor)e.getSource()).getColor()).execute();
                            new HidePencilCommand().execute();
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });
                }
            });
        }
    }

    private class TileColor extends JButton {

        private Color color;

        public TileColor ( Color color) {
            super();
            this.color=color;
            setBackground(color);
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

    }


}
