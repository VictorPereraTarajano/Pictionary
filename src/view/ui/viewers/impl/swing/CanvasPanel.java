package view.ui.viewers.impl.swing;

import controller.impl.command.pencil.DrawPencilCommand;
import controller.impl.command.pencil.HidePencilCommand;
import controller.impl.command.pencil.MovePencilCommand;
import controller.impl.command.pencil.ReleasePencilCommand;
import controller.impl.sendcommand.SendCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import view.ui.dialog.impl.swing.CanvasDialog;
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
    private CanvasDialog canvasDialog;

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
        createCanvasDialog();
        add(createCanvasDisplay(), BorderLayout.CENTER);
    }

    private void createCanvasDialog() {
        canvasDialog = new CanvasDialog();
    }

    private Component createCanvasDisplay() {
        return canvasDisplay = new CanvasDisplay();
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

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                new ReleasePencilCommand().execute();
                new SendCommand(new HidePencilCommand(), ManagerConnection.TCPBroadcast()).execute();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBlankCursor();
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        canvasDisplay.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                new DrawPencilCommand(e.getPoint()).execute();
                new SendCommand(new DrawPencilCommand(e.getPoint()), ManagerConnection.UDPBroadcast()).execute();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                new MovePencilCommand(e.getPoint()).execute();
            }
        });

    }

    private void setBlankCursor () {
        ManagerLobby.myLobbyFrame.getCanvasPanel().setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(16, 16, new int [16*16], 0, 16)), new Point(0, 0), "invisibleCursor"));
    }

    public CanvasDialog getCanvasDialog() {
        return canvasDialog;
    }

    public void setBackgroundColor(Color color) {
        canvasDisplay.setBackgroundColor(color);
        setBackground(color);
    }
}
