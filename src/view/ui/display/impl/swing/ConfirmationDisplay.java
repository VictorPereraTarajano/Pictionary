package view.ui.display.impl.swing;

import controller.impl.sendcommand.SendMessageCommand;
import model.message.impl.state.impl.SendLobbyStateMessage;
import model.messagedata.impl.ConfirmationData;
import model.messagedata.impl.statedata.impl.SendLobbyStateData;
import model.net.manager.ManagerConnection;
import view.ui.frame.managerlobby.ManagerLobby;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmationDisplay extends JDialog implements view.ui.display.interfaces.ConfirmationDisplay {

    private JLabel messageConfirmation;
    private ConfirmationData confirmationData;

    public ConfirmationDisplay(ConfirmationData confirmationData) {
        super();
        this.confirmationData = confirmationData;
        createWidgets();
        setVisible(true);
    }

    private void createWidgets() {
        add(createMessageConfirmation());
        add(createAcceptButton());
    }

    private Component createAcceptButton() {
        return new JButton("OK") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ManagerLobby.myLobby.getPlayerSet().add(confirmationData.getPlayer());
                        new SendMessageCommand(new SendLobbyStateMessage(new SendLobbyStateData(ManagerLobby.myLobby)), ManagerConnection.TCPBroadcast(ManagerLobby.myLobby.getPlayerSet().toArray())).execute();
                    }
                });
            }
        };
    }

    private Component createMessageConfirmation() {
        messageConfirmation=new JLabel();
        return messageConfirmation;
    }

    @Override
    public void display() {
        messageConfirmation.setText(confirmationData.getPlayer().getName()+" has join in the lobby");
    }
}
