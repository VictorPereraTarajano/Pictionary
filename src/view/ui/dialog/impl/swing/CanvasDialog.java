package view.ui.dialog.impl.swing;

import controller.impl.sendcommand.SendMessageCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.statemessage.impl.SendCanvasStateMessage;
import model.statemessagedata.impl.SendCanvasStateData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CanvasDialog extends JPanel implements view.ui.dialog.interfaces.CanvasDialog {

    public CanvasDialog() {
        super();
        setBorder(BorderFactory.createTitledBorder("Canvas Options"));
        setLayout(new GridLayout(1,1));
        createWidgets();
    }

    private void createWidgets() {
        add(createClearButton());
    }

    private Component createClearButton() {
        return new JButton("CLEAR") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            ManagerLobby.myLobby.getCanvas().clear();
                            new SendMessageCommand(new SendCanvasStateMessage(SendCanvasStateData.CLEAR), ManagerConnection.TCPBroadcast()).execute();
                    }
            });
            }
        };
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
