package view.ui.dialog.impl.swing;

import controller.impl.command.canvas.ClearCanvasCommand;
import controller.impl.command.turn.StopTurnCommand;
import controller.impl.command.pencil.HidePencilCommand;
import controller.impl.command.pencil.options.UpdatePencilDimensionCommand;
import controller.impl.command.popups.palette.ShowPaletteColourDialogCommand;
import controller.impl.sendcommand.SendCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import view.persistence.impl.loaders.image.FactoryImageLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class CanvasOptionsDialog extends JPanel implements view.ui.dialog.interfaces.CanvasDialog {

    private PaletteColourDialog paletteColourDialog;

    public CanvasOptionsDialog() {
        super();
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setPreferredSize(new Dimension(200,40));
        createWidgets();
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                new HidePencilCommand().execute();
                ManagerLobby.myLobbyFrame.getCanvasPanel().setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        setOpaque(false);
    }

    private void createWidgets() {
        add(createClearButton());
        add(createBigPencilButton());
        add(createMediumPencilButton());
        add(createSmallPencilButton());
        add(createPalette());
        add(createStopTurnButton());
    }

    private Component createStopTurnButton() {
        return new JButton() {
            {
                setPreferredSize(new Dimension(25,25));
                setIcon(new ImageIcon(FactoryImageLoader.CANCEL_CANVAS_DIALOG));
                setContentAreaFilled(false);
                setBorderPainted(false);
                setBackground(new Color(225 ,218,89));
                setBorder(BorderFactory.createEmptyBorder());
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new SendCommand(new StopTurnCommand("El pintor "+ManagerLobby.myPlayer.getName()+" ha cancelado el turno"), ManagerConnection.TCPBroadcastAll()).execute();
                    }
                });
            }
        };
    }

    public PaletteColourDialog getPaletteColourDialog() {
        return paletteColourDialog;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g2d.setColor(new Color(225 ,218,89));
        g2d.fillRoundRect(0, 0, getLayout().preferredLayoutSize(this).width, getLayout().preferredLayoutSize(this).height, 10, 10);
    }

    private Component createPalette() {
        paletteColourDialog = new PaletteColourDialog();
        return new JButton() {
            {
                setPreferredSize(new Dimension(25, 25));
                setBackground(Color.BLACK);
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new ShowPaletteColourDialogCommand(((JComponent) e.getSource())).execute();
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
                        new SendCommand(new UpdatePencilDimensionCommand(new Dimension(5,5)), ManagerConnection.TCPBroadcastAll()).execute();
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
                        new SendCommand(new UpdatePencilDimensionCommand(new Dimension(15,15)), ManagerConnection.TCPBroadcastAll()).execute();
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
                        new SendCommand(new UpdatePencilDimensionCommand(new Dimension(10,10)), ManagerConnection.TCPBroadcastAll()).execute();
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
                        new SendCommand(new ClearCanvasCommand(), ManagerConnection.TCPBroadcastAll()).execute();
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
                    g2d.drawImage(ImageIO.read(getClass().getResource("/canvas/clear.png")), 2,2,20,20,null);
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

    public void refresh(Color color) {
        getComponent(getComponentCount()-2).setBackground(color);
    }
}
