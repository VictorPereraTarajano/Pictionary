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
    private JButton deleteButton, cancelButton;
    private Lobby lobby;

    public KickPlayerDialog(Lobby lobby) {
        this.lobby=lobby;
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
        cancelButton = new JButton("CANCEL");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        return cancelButton;
    }

    private Component createDeleteButton() {
        deleteButton = new JButton("DELETE");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SendMessageCommand(new KickPlayerMessage(new KickPlayerData()), new UDPSender(((Player) list.getSelectedValue()).getIp())).execute();
            }
        });
        return deleteButton;
    }

    private Component createList() {
        Object [] playerArray = lobby.getPlayerSet().getPlayerList().toArray();
        if (playerArray.length <= 0) {
            return new JLabel("No players in the lobby yet");
        } else {
            list = new JList(playerArray);
            list.setOpaque(false);
            return list;
        }
    }

    @Override
    public Player getPlayer() {
        return (Player) list.getSelectedValue();
    }
}
