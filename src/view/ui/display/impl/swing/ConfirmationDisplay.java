package view.ui.display.impl.swing;

import controller.impl.command.lobby.CreateLobbyCommand;
import controller.impl.command.scoring.UpdatePlayerScoringCommand;
import controller.impl.sendcommand.SendMessageCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerGame;
import model.manager.ManagerLobby;
import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmationDisplay extends JDialog implements view.ui.display.interfaces.ConfirmationDisplay {

    private static final int WIDTH=200, HEIGHT=200;
    private static ConfirmationDisplay mySelf;

    private JLabel messageConfirmation;
    private Player player;

    public ConfirmationDisplay(Player player) {
        super();
        mySelf=this;
        this.player=player;
        setLocation(500, 500);
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
                        player.setColor(ManagerGame.getAvailableColor());
                        new SendMessageCommand(new CreateLobbyCommand(ManagerLobby.myLobby), ManagerConnection.TCPBroadcast(new Player [] {player})).execute();
                        new SendMessageCommand(new UpdatePlayerScoringCommand(player), ManagerConnection.TCPBroadcast()).execute();
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
        messageConfirmation.setText(player.getName()+" has join in the lobby");
    }
}
