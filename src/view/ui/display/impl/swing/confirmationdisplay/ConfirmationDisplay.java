package view.ui.display.impl.swing.confirmationdisplay;

import controller.impl.sendcommand.SendMessageCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.message.impl.state.impl.SendLobbyStateMessage;
import model.messagedata.impl.ConfirmationData;
import model.messagedata.impl.statedata.impl.SendLobbyStateData;
import model.scoring.Score;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmationDisplay extends JDialog implements view.ui.display.interfaces.confirmationdisplay.ConfirmationDisplay {

    private static final int WIDTH=200, HEIGHT=200;
    private static ConfirmationDisplay mySelf;

    private JLabel messageConfirmation;
    private ConfirmationData confirmationData;

    public ConfirmationDisplay(ConfirmationData confirmationData) {
        super();
        mySelf=this;
        this.confirmationData = confirmationData;
        setLocation(500,500);
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
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
                        ManagerLobby.myLobby.getScoring().add(confirmationData.getPlayer(), new Score(0));
                        new SendMessageCommand(new SendLobbyStateMessage(new SendLobbyStateData(ManagerLobby.myLobby)), ManagerConnection.TCPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers())).execute();
                        mySelf.setVisible(false);
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
