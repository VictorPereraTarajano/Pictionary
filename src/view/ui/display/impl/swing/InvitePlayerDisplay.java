package view.ui.display.impl.swing;

import controller.impl.command.lobby.CreateLobbyCommand;
import controller.impl.command.player.ShowConfirmationDisplayCommand;
import controller.impl.sendcommand.SendMessageCommand;
import model.game.Lobby;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvitePlayerDisplay extends JDialog implements view.ui.display.interfaces.InvitePlayerDisplay {

    private static final int WIDTH=200, HEIGHT=200;
    private static InvitePlayerDisplay mySelf;
    private JLabel messageInvitation;

    private Lobby lobby;
    private Player player;

    public InvitePlayerDisplay(Lobby lobby, Player player) {
        super();
        mySelf=this;
        this.lobby=lobby;
        this.player=player;
        setLayout(new GridLayout(0, 2));
        setLocation(500,500);
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        createWidgets();
        setVisible(true);
    }

    private void createWidgets() {
        add(createMessageInvitation());
        add(createAcceptButton());
        add(createCancelButton());
    }

    private Component createMessageInvitation() {
        messageInvitation=new JLabel();
        return messageInvitation;
    }

    private Component createCancelButton() {
        return new JButton("CANCEL") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                    }
                });
            }
        };
    }

    private Component createAcceptButton() {
        return new JButton("OK"){
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new CreateLobbyCommand(lobby).execute();
                        new SendMessageCommand(new ShowConfirmationDisplayCommand(ManagerLobby.myPlayer), ManagerConnection.TCPBroadcast(new Player[]{player})).execute();
                        mySelf.setVisible(false);
                    }
                });
            }
        };
    }

    @Override
    public void display() {
        messageInvitation.setText("You have been invited by "+player.getName()+" to a new lobby");
    }
}
