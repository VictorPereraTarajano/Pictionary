package view.ui.viewers.impl.swing;

import controller.impl.sendcommand.SendMessageCommand;
import model.message.impl.state.impl.SendCanvasStateMessage;
import model.message.impl.state.impl.SendChatStateMessage;
import model.messagedata.impl.statedata.impl.SendCanvasStateData;
import model.messagedata.impl.statedata.impl.SendChatStateData;
import model.net.manager.ManagerConnection;
import view.ui.frame.impl.swing.LobbyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CanvasPanel extends JPanel {

    private Point p = new Point(0,0);

    public CanvasPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Canvas Panel"));
        addListeners();
    }

    private void addListeners() {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                new SendMessageCommand(new SendCanvasStateMessage(new SendCanvasStateData(new Point(e.getX(),e.getY()))), ManagerConnection.UDPBroadcast(SendChatStateMessage.LobbyFrame.getLobby().getPlayerSet().toArray())).execute();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawOval(p.x, p.y,2,2);
    }

    public void display (SendCanvasStateData sendCanvasStateData) {
        p=sendCanvasStateData.getPoint();
        repaint();
    }

}
