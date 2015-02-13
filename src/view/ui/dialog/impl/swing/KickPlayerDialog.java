package view.ui.dialog.impl.swing;

import controller.impl.sendcommand.SendMessageCommand;
import model.message.impl.KickPlayerMessage;
import model.messagedata.impl.KickPlayerData;
import model.game.Lobby;
import model.player.Player;
import model.net.sender.impl.UDPSender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KickPlayerDialog extends JDialog implements view.ui.dialog.interfaces.KickPlayerDialog {

    private static final int WIDTH=350, HEIGHT=100;

    private JList list;

    public KickPlayerDialog(Lobby lobby) {
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new GridLayout(2,2));
        createWidgets(lobby);
        setVisible(true);
    }

    private void createWidgets(Lobby lobby) {
        add(new JLabel("List of current players : "));
        add(createList(lobby));
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
                        new SendMessageCommand(new KickPlayerMessage(new KickPlayerData()), new UDPSender(((Player) list.getSelectedValue()).getIp())).execute();
                    }
                });
            }
        };
    }

    private Component createList(Lobby lobby) {
        Object [] playerArray = lobby.getPlayerSet().toArray();
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
