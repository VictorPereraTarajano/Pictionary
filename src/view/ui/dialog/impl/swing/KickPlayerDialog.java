package view.ui.dialog.impl.swing;

import controller.impl.sendcommand.SendMessageCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.message.impl.KickPlayerMessage;
import model.messagedata.impl.KickPlayerData;
import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KickPlayerDialog extends JDialog implements view.ui.dialog.interfaces.KickPlayerDialog {

    private static final int WIDTH=350, HEIGHT=100;

    private JList list;

    public KickPlayerDialog() {
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new GridLayout(2,2));
        createWidgets();
        setVisible(true);
    }

    private void createWidgets() {
        add(new JLabel("List of current players : "));
        add(createList());
        add(createCancelButton());
        add(createDeleteButton());
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

    private Component createDeleteButton() {
        return new JButton("DELETE") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new SendMessageCommand(new KickPlayerMessage(new KickPlayerData((Player) list.getSelectedValue(), "You have kicked")), ManagerConnection.TCPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers())).execute();
                    }
                });
            }
        };
    }

    private Component createList() {
        Player [] playerArray = ManagerLobby.myLobby.getScoring().getAllWithoutMe();
        if (playerArray.length <= 0)
            return new JLabel("No players in the lobby yet");
        else
            return new JList(playerArray){
                {
                    setOpaque(false);
                }
            };

    }

    @Override
    public Player getPlayer() {
        return (Player) list.getSelectedValue();
    }
}
