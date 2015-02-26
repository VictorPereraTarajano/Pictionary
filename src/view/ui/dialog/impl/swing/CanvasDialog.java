package view.ui.dialog.impl.swing;

import controller.impl.sendcommand.SendMessageCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.statemessage.impl.SendCanvasStateMessage;
import model.statemessagedata.impl.SendCanvasStateData;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CanvasDialog extends JPanel implements view.ui.dialog.interfaces.CanvasDialog {

    public CanvasDialog() {
        super();
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setPreferredSize(new Dimension(100,40));
        createWidgets();
        setBackground(new Color(250,56,56));
    }

    private void createWidgets() {
        add(createClearButton());
        add(createBigPencilButton());
        add(createMediumPencilButton());
        add(createSmallPencilButton());
        add(createPalette());
    }

    private Component createPalette() {
        final JPopupMenu popupMenu = new JPopupMenu() {
            {
                setPopupSize(new Dimension(50,50));
                setBackground(Color.BLUE);
                setVisible(false);
            }
        };
        return new JButton () {
            {
                setPreferredSize(new Dimension(25,25));
                add(popupMenu);
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        popupMenu.setVisible(true);
                    }
                });
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                super.paintComponent(g2d);
                g2d.setColor(Color.BLACK);
                g2d.fillRect(2,2,getSize().width-4, getSize().height-4);
            }
        };
    }

    private Component createSmallPencilButton() {
        return new JButton() {

            {
                setPreferredSize(new Dimension(25,25));
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ManagerLobby.myLobby.getCanvas().getPencil().setDimension(new Dimension(5,5));
                    }
                });
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                super.paintComponent(g2d);
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0,0,this.getWidth(),this.getHeight());
                g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
                g2d.setColor(Color.BLACK);
                g2d.fillOval(10,10,5,5);
            }
        };
    }

    private Component createBigPencilButton() {
        return new JButton() {

            {
                setPreferredSize(new Dimension(25,25));
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ManagerLobby.myLobby.getCanvas().getPencil().setDimension(new Dimension(15,15));
                    }
                });
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                super.paintComponent(g2d);
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0,0,this.getWidth(),this.getHeight());
                g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
                g2d.setColor(Color.BLACK);
                g2d.fillOval(5,5,15,15);
            }
        };
    }

    private Component createMediumPencilButton() {
        return new JButton() {

            {
                setPreferredSize(new Dimension(25,25));
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ManagerLobby.myLobby.getCanvas().getPencil().setDimension(new Dimension(10,10));
                    }
                });
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                super.paintComponent(g2d);
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0,0,this.getWidth(),this.getHeight());
                g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
                g2d.setColor(Color.BLACK);
                g2d.fillOval(8,8,10,10);
            }
        };
    }

    private Component createClearButton() {
        return new JButton() {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            ManagerLobby.myLobby.getCanvas().clear();
                            new SendMessageCommand(new SendCanvasStateMessage(SendCanvasStateData.CLEAR), ManagerConnection.TCPBroadcast()).execute();
                    }

            });
                setPreferredSize(new Dimension(25,25));
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                super.paintComponent(g);
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0,0,this.getWidth(),this.getHeight());
                g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
                try {
                    g2d.drawImage(ImageIO.read(getClass().getResource("/clear.png")), 2,2,20,20,null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Point getPoint() {
        return null;
    }

    @Override
    public boolean getClearOption() {
        return false;
    }

    @Override
    public Color getColor() {
        return null;
    }
}
