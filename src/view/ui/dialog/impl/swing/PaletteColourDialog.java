package view.ui.dialog.impl.swing;

import controller.impl.command.pencil.HidePencilCommand;
import controller.impl.command.pencil.options.UpdatePencilColorCommand;
import controller.impl.command.player.popups.HidePaletteColourDialog;
import controller.impl.sendcommand.SendCommand;
import model.manager.ManagerConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PaletteColourDialog extends JPopupMenu {

    private final int tiles = 5;

    public PaletteColourDialog() {
        super();
        setPreferredSize(new Dimension(100, 100));
        setBackground(Color.WHITE);
        setLayout(new GridLayout(5, 5));
        createPalette();
    }

    private void createPalette() {
        for (int i = 0; i < tiles*tiles; i++) {
            add(new TileColor(new Color((i)%255, (i*3)%255, (i*6)%255)) {
                {
                    addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new SendCommand(new UpdatePencilColorCommand(((TileColor)e.getSource()).getColor()), ManagerConnection.TCPBroadcastAll()).execute();
                            new HidePaletteColourDialog().execute();
                        }
                    });
                    addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {

                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
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
