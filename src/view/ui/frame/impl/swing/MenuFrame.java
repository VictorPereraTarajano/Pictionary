package view.ui.frame.impl.swing;

import controller.impl.command.connection.ConnectCommand;
import controller.impl.command.connection.DisconnectCommand;
import controller.impl.command.lobby.CreateLobbyCommand;
import controller.impl.command.player.RegisterPlayerCommand;
import model.game.Lobby;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.manager.ManagerMenu;
import view.persistence.impl.loaders.image.FactoryImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {

    private static final int WIDTH=480,HEIGHT=400;
    private static final String TITLE="Menu Pictionary";
    private Color backgroundColor = new Color(105, 202, 136);
    private Color backgroundButtonsColor =  new Color(134, 203, 107);
    private JLabel log;

    public MenuFrame() {
        super(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIcon();
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());
        createWidgets();
        setLocation(500,500);
    }

    private void setIcon() {
        setIconImage(FactoryImageLoader.ICON_FRAME);
    }

    private void createWidgets() {
        add(new JPanel() {
            {
                setLayout(new BorderLayout());
                setBackground(Color.DARK_GRAY);
                add(new JLabel() {
                    {
                        setFont(new Font("Agency FB", Font.BOLD, 18));
                        setText("  Welcome to Pictionary");
                        setForeground(Color.WHITE);
                    }
                }, BorderLayout.CENTER);
                add(createConnectDisconnectButton(), BorderLayout.EAST);
            }
        }, BorderLayout.NORTH);
        add(new JPanel() {
            {
                setLayout(new BorderLayout());
                add(new JPanel () {
                    {
                        setBackground(backgroundColor);
                        setLayout(new FlowLayout(FlowLayout.CENTER));
                        add(createTitle());
                    }
                }, BorderLayout.NORTH);
                add(createPanelButtons(), BorderLayout.CENTER);
            }
        }, BorderLayout.CENTER);
        add(createLogLabel(), BorderLayout.SOUTH);
    }

    private Component createTitle() {
        return new JLabel() {
            {
                setIcon(new ImageIcon(FactoryImageLoader.TITLE));
            }
        };
    }

    private JPanel createPanelButtons() {
        return new JPanel() {
            {
                add(createRegisterPlayerButton());
                add(createLobbyButton());
                add(createOptionsButton());
                add(createExitButton());
                setLayout(new GridLayout(4,1,5,5));
                setBackground(backgroundColor);
                setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            }
        };
    }

    private Component createOptionsButton() {
        return new JButton() {
            {
                setFont(new Font("Agency FB", Font.BOLD, 30));
                setText("Options");
                setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });
                setBackground(backgroundButtonsColor);
            }
        };
    }

    private Component createLogLabel() {
        return new JPanel () {
            {
                setLayout(new FlowLayout(FlowLayout.LEFT));
                log = new JLabel() {
                    {
                        setText(ManagerConnection.getStatus());
                        setFont(new Font("Agency FB", Font.BOLD, 18));
                        setForeground(Color.WHITE);
                    }
                };
                add(log);
                setBackground(Color.DARK_GRAY);
            }
        };
    }

    private Component createConnectDisconnectButton() {
        return new JButton() {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (ManagerConnection.getStatus().equals(ManagerConnection.CONNECTED)) {
                            new DisconnectCommand().execute();
                            setIcon(new ImageIcon(FactoryImageLoader.OFF_BUTTON.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
                        } else {
                            new ConnectCommand().execute();
                            setIcon(new ImageIcon(FactoryImageLoader.ON_BUTTON.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
                        }
                        log.setText(ManagerConnection.getStatus());
                    }
                });
                setOpaque(false);
                setContentAreaFilled(false);
                setBorderPainted(false);
                setBorder(BorderFactory.createEmptyBorder());
                setIcon(new ImageIcon(FactoryImageLoader.OFF_BUTTON.getScaledInstance(30,30, Image.SCALE_SMOOTH)));
            }
        };
    }

    private Component createExitButton() {
        return new JButton() {
            {
                setFont(new Font("Agency FB", Font.BOLD, 30));
                setText("Exit");
                setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                setBackground(backgroundButtonsColor);
            }
        };
    }

    private Component createRegisterPlayerButton() {
        return new JButton() {
            {
                setFont(new Font("Agency FB", Font.BOLD, 30));
                setText("Register Player");
                setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new RegisterPlayerCommand().execute();
                    }
                });
                setBackground(backgroundButtonsColor);
            }
        };
    }

    private Component createLobbyButton() {
        return new JButton(){
            {
                setFont(new Font("Agency FB", Font.BOLD, 30));
                setText("Create Lobby");
                setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new CreateLobbyCommand(new Lobby()).execute();
                        ManagerLobby.myLobbyFrame.setVisible(true);
                        ManagerMenu.menuFrame.setVisible(false);
                    }
                });
                setEnabled(false);
                setBackground(backgroundButtonsColor);
            }
        };
    }
}
