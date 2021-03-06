package view.ui.dialog.impl.swing;

import controller.impl.command.popups.inviteplayer.ShowInvitePlayerDisplayCommand;
import controller.impl.sendcommand.SendCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvitePlayerDialog extends JDialog implements view.ui.dialog.interfaces.InvitePlayerDialog {

    private static final int WIDTH=350, HEIGHT=130;
    private JTextField ipField;
    private InvitePlayerDialog mySelf;

    public InvitePlayerDialog() {
        super();
        setTitle("Invite Player");
        mySelf=this;
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(105, 202, 136));
        setLocation(500,500);
        createWidgets();
        setVisible(true);
    }

    private void createWidgets() {
        add(new JPanel() {
            {
                setBackground(new Color(105, 202, 136));
                setLayout(new GridLayout(1,2,5,5));
                setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
                add(new JLabel() {
                    {
                        setFont(new Font("Agency FB", Font.BOLD, 20));
                        setText("Insert player IP : ");
                    }
                });
                add(createIpField());
            }
        }, BorderLayout.NORTH);
        add(new JPanel() {
            {
                setBackground(new Color(105, 202, 136));
                setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
                setLayout(new GridLayout(1,2,5,5));
                add(createButtonAccept());
                add(createButtonCancel());
            }
        }, BorderLayout.SOUTH);
    }

    private Component createButtonCancel() {
        return new JButton() {
            {
                setFont(new Font("Agency FB", Font.BOLD, 20));
                setText("Cancel");
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                    }
                });
                setBackground(new Color(134, 203, 107));
            }
        };
    }

    private Component createButtonAccept() {
        return new JButton() {
            {
                setFont(new Font("Agency FB", Font.BOLD, 20));
                setText("Invite");
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new SendCommand(new ShowInvitePlayerDisplayCommand(ManagerLobby.myLobby, ManagerLobby.myPlayer), ManagerConnection.TCPBroadcast(new Player[] { new Player("", getIP())})).execute();
                        mySelf.setVisible(false);
                    }
                });
                setBackground(new Color(134, 203, 107));
            }
        };
    }

    private Component createIpField() {
        return ipField= new JTextField(15);
    }

    private String getIP () {
        return this.ipField.getText();
    }
}
