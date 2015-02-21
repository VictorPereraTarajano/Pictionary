package view.ui.display.impl.swing;

import controller.impl.sendcommand.SendMessageCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerGame;
import model.manager.ManagerLobby;
import model.messagedata.impl.ConfirmationData;
import model.scoring.Score;
import model.statemessage.impl.SendScoringStateMessage;
import model.statemessagedata.impl.SendScoringStateData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmationDisplay extends JDialog implements view.ui.display.interfaces.ConfirmationDisplay {

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
                        confirmationData.getPlayer().setColor(ManagerGame.getAvailableColor());
                        ManagerLobby.myLobby.getScoring().add(confirmationData.getPlayer(), new Score(0));
                        new SendMessageCommand(new SendScoringStateMessage(new SendScoringStateData(ManagerLobby.myLobby.getScoring())), ManagerConnection.TCPBroadcast()).execute();
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
