package view.ui.viewers.impl.swing;

import controller.impl.sendcommand.SendMessageCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.statemessage.impl.SendCanvasStateMessage;
import model.statemessagedata.impl.SendCanvasStateData;
import view.ui.display.impl.swing.CanvasDisplay;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.MemoryImageSource;

public class CanvasPanel extends JPanel implements view.ui.viewers.interfaces.CanvasPanel {

    private CanvasDisplay canvasDisplay;

    public CanvasPanel() {
        super();
        setBorder(new EmptyBorder(0,10,10,10));
        setLayout(new BorderLayout());
        createWidgets();
        addListeners();
    }

    @Override
    public CanvasDisplay getCanvasDisplay() {
        return canvasDisplay;
    }

    @Override
    public void refresh() {
        canvasDisplay.display();
    }

    private void createWidgets() {
        add(createCanvasDisplay(), BorderLayout.CENTER);
    }

    private Component createCanvasDisplay() {
        return canvasDisplay = new CanvasDisplay();
    }

    private void sendMessage (Point point, boolean isPainting) {
        ManagerLobby.myLobby.getCanvas().getPencil().setPainting(isPainting);
        ManagerLobby.myLobby.getCanvas().getPencil().setPosition(point);
        if (ManagerLobby.myLobby.getGame() == null || ManagerLobby.myLobby.getGame().currentTurn().getPlayer().equals(ManagerLobby.myPlayer)) {
            ManagerLobby.myLobby.getCanvas().add(point);
            if (ManagerLobby.myLobby.getCanvas().getPointList().size() >= ManagerLobby.myLobby.getCanvas().MAX_SIZE_BUFFER)
                new SendMessageCommand(new SendCanvasStateMessage(new SendCanvasStateData((ManagerLobby.myLobby.getCanvas().getPointList().toArray(new Point[ManagerLobby.myLobby.getCanvas().getPointList().size()])), ManagerLobby.myLobby.getCanvas().getPencil())), ManagerConnection.TCPBroadcast()).execute();
        }
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(500,100);
    }

    private void addListeners() {
        canvasDisplay.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                sendMessage(new Point(e.getX(), e.getY()), true);
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
                sendMessage(e.getPoint(), true);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                sendMessage(e.getPoint(), false);
            }
        });

        canvasDisplay.addMouseListener(new MouseListener() {
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
                setBlankCursor();
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

    }

    private void setBlankCursor () {
        ManagerLobby.myLobbyFrame.getCanvasPanel().setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(16, 16, new int [16*16], 0, 16)), new Point(0, 0), "invisibleCursor"));
    }

    public void setBackgroundColor(Color color) {
        canvasDisplay.setBackgroundColor(color);
        setBackground(color);
    }
}
