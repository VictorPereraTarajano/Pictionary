package view.ui.dialog.impl.swing;

import controller.impl.command.canvas.ClearCanvasCommand;
import controller.impl.command.pencil.options.UpdatePencilDimensionCommand;
import controller.impl.sendcommand.SendMessageCommand;
import model.manager.ManagerConnection;

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
        setPreferredSize(new Dimension(200,40));
        createWidgets();
        setOpaque(false);
    }

    private void createWidgets() {
        add(createClearButton());
        add(createBigPencilButton());
        add(createMediumPencilButton());
        add(createSmallPencilButton());
        add(createPalette());
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g2d.setColor(new Color(225,218,89));
        g2d.fillRoundRect(0, 0, getLayout().preferredLayoutSize(this).width, getLayout().preferredLayoutSize(this).height, 10, 10);
    }

    private Component createPalette() {
        return new JPopupMenu() {
            {
                add(new JPanel() {
                    {
                        setBackground(Color.BLUE);
                    }
                });
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
                        new SendMessageCommand(new UpdatePencilDimensionCommand(new Dimension(5,5)), ManagerConnection.TCPBroadcastAll()).execute();
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
                        new SendMessageCommand(new UpdatePencilDimensionCommand(new Dimension(15,15)), ManagerConnection.TCPBroadcastAll()).execute();
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
                        new SendMessageCommand(new UpdatePencilDimensionCommand(new Dimension(10,10)), ManagerConnection.TCPBroadcastAll()).execute();
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
                        new SendMessageCommand(new ClearCanvasCommand(), ManagerConnection.TCPBroadcastAll()).execute();
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
