package view.ui.dialog.impl.swing;

import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.manager.ManagerMenu;
import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPlayerDialog extends JDialog implements view.ui.dialog.interfaces.RegisterPlayerDialog {

    private final int WIDTH =320, HEIGHT=120;
    private JTextField playerNameField;

    private static JDialog mySelf;

    public RegisterPlayerDialog() {
        super();
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setTitle("Register Playername");
        mySelf=this;
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new BorderLayout());
        createWidgets();
        setLocation(500,500);
        setVisible(true);
    }

    private void createWidgets() {
        add(new JPanel() {
            {
                setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
                setLayout(new GridLayout(1,2,10,10));
                add(createPlayerLabel());
                add(createPlayerNameField());
                setBackground(new Color(105, 202, 136));
            }
        }, BorderLayout.NORTH);

        add(new JPanel() {
            {
                setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
                setLayout(new GridLayout(1,2,5,5));
                add(createAcceptButton());
                add(createCancelButton());
                setBackground(new Color(105, 202, 136));
            }
        }, BorderLayout.SOUTH);
    }

    private JLabel createPlayerLabel() {
        return new JLabel() {
            {
                setFont(new Font("Agency FB", Font.BOLD, 20));
                setText("Your playername : ");
            }
        };
    }

    private Component createCancelButton() {
        return new JButton(){
            {
                setFont(new Font("Agency FB", Font.BOLD, 20));
                setText("Cancel");
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
        return new JButton() {
            {
                setFont(new Font("Agency FB", Font.BOLD, 20));
                setText("Ok");
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (playerNameField.getText().trim().isEmpty())
                            new JOptionPane().showMessageDialog(mySelf, "Your playername is empty !!", "Failed to register", JOptionPane.WARNING_MESSAGE);
                        else {
                            ManagerLobby.myPlayer = getPlayer();
                            ((JPanel)ManagerMenu.menuFrame.getContentPane().getComponents()[1]).getComponent(1).setEnabled(true);
                            ((JButton)((JPanel)ManagerMenu.menuFrame.getContentPane().getComponents()[1]).getComponent(0)).setText("Change Playername");
                            mySelf.setVisible(false);
                        }
                    }
                });
                setBackground(new Color(154, 235, 180));
            }
        };
    }

    private Component createPlayerNameField() {
        return playerNameField = new JTextField() {
            {
                setToolTipText("Your playername");
            }
        };
    }

    @Override
    public Player getPlayer() {
        return new Player(playerNameField.getText(), ManagerConnection.DefaultIP);
    }
}
