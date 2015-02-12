package view.ui.viewers.impl.swing;

import controller.impl.sendcommand.SendMessageCommand;
import model.message.impl.state.impl.SendCanvasStateMessage;
import model.message.impl.state.impl.SendChatStateMessage;
import model.messagedata.impl.statedata.impl.SendCanvasStateData;
import model.net.manager.ManagerConnection;
import view.ui.display.impl.swing.CanvasDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CanvasPanel extends JPanel {

    private CanvasDisplay canvasDisplay;

    public CanvasPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Canvas Panel"));
        setLayout(new GridLayout(1,0));
        createWidgets();
        addListeners();
    }

    public CanvasDisplay getCanvasDisplay() {
        return canvasDisplay;
    }

    private void createWidgets() {
        add(createCanvasDisplay());
    }

    private Component createCanvasDisplay() {
        canvasDisplay = new CanvasDisplay();
        return canvasDisplay;
    }

    private void addListeners() {
        canvasDisplay.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                canvasDisplay.display(new SendCanvasStateData(new Point(e.getX(), e.getY())));
                new SendMessageCommand(new SendCanvasStateMessage(new SendCanvasStateData(new Point(e.getX(), e.getY()))), ManagerConnection.UDPBroadcast(SendChatStateMessage.LobbyFrame.getLobby().getPlayerSet().toArray())).execute();
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
        canvasDisplay.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                canvasDisplay.display(new SendCanvasStateData(new Point(e.getX(), e.getY())));
                new SendMessageCommand(new SendCanvasStateMessage(new SendCanvasStateData(new Point(e.getX(), e.getY()))), ManagerConnection.UDPBroadcast(SendChatStateMessage.LobbyFrame.getLobby().getPlayerSet().toArray())).execute();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

}
