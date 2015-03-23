package view.ui.display.impl.swing;

import controller.impl.command.lobby.CreateLobbyCommand;
import controller.impl.command.scoring.AddPlayerScoringCommand;
import controller.impl.command.scoring.UpdatePlayerScoringCommand;
import controller.impl.sendcommand.SendCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.player.Player;
import model.scoring.Score;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmationDisplay extends JDialog implements view.ui.display.interfaces.ConfirmationDisplay {

    private static ConfirmationDisplay mySelf;

    private JLabel messageConfirmation;
    private Player player;

    public ConfirmationDisplay(Player player) {
        super();
        setTitle("Confirmation Invite");
        mySelf=this;
        this.player=player;
        setLocation(500, 500);
        setLayout(new BorderLayout());
        createWidgets();
        pack();
        setVisible(true);
    }

    private void createWidgets() {
        add(new JPanel () {
            {
                setLayout(new BorderLayout());
                setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
                setBackground(new Color(105, 202, 136));
                add(createMessageConfirmation(), BorderLayout.CENTER);
            }
        }, BorderLayout.NORTH);
        add(new JPanel() {
            {
                setBackground(new Color(105, 202, 136));
                setLayout(new GridLayout(1,2,10,10));
                setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
                add(createAcceptButton());
                add(createCancelButton());
            }


        }, BorderLayout.SOUTH);
    }

    private Component createCancelButton() {
        return new JButton("CANCEL") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mySelf.setVisible(false);
                    }
                });
                setBackground(new Color(154, 235, 180));
            }
        };
    }

    private Component createAcceptButton() {
        return new JButton("OK") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new AddPlayerScoringCommand(player).execute();
                        new SendCommand(new CreateLobbyCommand(ManagerLobby.myLobby), ManagerConnection.TCPBroadcast(new Player [] {player})).execute();
                        new SendCommand(new UpdatePlayerScoringCommand(player, new Score(0)), ManagerConnection.TCPBroadcast()).execute();
                        mySelf.setVisible(false);
                    }
                });
                setBackground(new Color(154, 235, 180));
            }
        };
    }

    private Component createMessageConfirmation() {
        return messageConfirmation=new JLabel("<html> <font style=\"font-size:9px;\">The player "+player.getName()+" has accepted your invitation to join the lobby <br><br>" +
                                              "        <p style=\"text-indent:45px;\">¿Do you want to add him to the actual lobby?</p></font></html>");
    }

    @Override
    public void display() {
        messageConfirmation.setText(player.getName()+" has join in the lobby");
    }
}
