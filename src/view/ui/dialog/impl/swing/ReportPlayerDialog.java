package view.ui.dialog.impl.swing;

import controller.impl.command.pencil.HidePencilCommand;
import controller.impl.command.popups.ShowReportPlayerDisplay;
import model.manager.ManagerLobby;
import view.persistence.impl.loaders.image.FactoryImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class ReportPlayerDialog extends JButton {

    private BufferedImage image;

    public ReportPlayerDialog() {
        setPreferredSize(new Dimension(64,64));
        image = FactoryImageLoader.REPORT_PLAYER;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                image = FactoryImageLoader.REPORT_PLAYER_2;
                new ShowReportPlayerDisplay().execute();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                image = FactoryImageLoader.REPORT_PLAYER;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                new HidePencilCommand().execute();
                changeCursor();
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void changeCursor () {
        ManagerLobby.myLobbyFrame.getCanvasPanel().setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,null);
    }
}
