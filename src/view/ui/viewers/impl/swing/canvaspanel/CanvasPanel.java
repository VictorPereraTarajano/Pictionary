package view.ui.viewers.impl.swing.canvaspanel;

import controller.impl.sendcommand.SendMessageCommand;
import model.message.impl.state.impl.SendCanvasStateMessage;
import model.messagedata.impl.statedata.impl.SendCanvasStateData;
import model.manager.ManagerConnection;
import view.ui.dialog.impl.swing.canvasdialog.CanvasDialog;
import view.ui.display.impl.awt.CanvasDisplay;
import model.manager.ManagerLobby;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CanvasPanel extends JPanel implements view.ui.viewers.interfaces.canvaspanel.CanvasPanel {

    private CanvasDisplay canvasDisplay;
    private CanvasDialog canvasDialog;

    public CanvasPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Canvas Panel"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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
        add(createCanvasOptions());
        add(createCanvasDisplay());
    }

    private Component createCanvasOptions() {
        canvasDialog =new CanvasDialog();
        return canvasDialog;
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
                new SendMessageCommand(new SendCanvasStateMessage(new SendCanvasStateData(new Point(e.getX(), e.getY()))), ManagerConnection.UDPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers())).execute();
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
                new SendMessageCommand(new SendCanvasStateMessage(new SendCanvasStateData(new Point(e.getX(), e.getY()))), ManagerConnection.UDPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers())).execute();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });
    }

}
