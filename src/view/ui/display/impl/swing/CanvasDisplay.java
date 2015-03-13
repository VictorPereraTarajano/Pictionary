package view.ui.display.impl.swing;

import model.manager.ManagerLobby;
import view.ui.dialog.impl.swing.CanvasDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CanvasDisplay extends JPanel implements view.ui.display.interfaces.CanvasDisplay {

    private Graphics2D g2d;
    public BufferedImage image = null;
    private Color backgroundColor;
    private Point lastPoint;
    private PencilDisplay painterDisplay;

    public CanvasDisplay() {
        super();
        setLayout(new BorderLayout());
        createWidgets();
        painterDisplay=new PencilDisplay();
    }

    public void setLastPoint(Point lastPoint) {
        this.lastPoint = lastPoint;
    }

    private void createWidgets() {
        add(new CanvasDialog(), BorderLayout.NORTH);
    }

    @Override
    public void update(Graphics g) {
        paintComponent(g);
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        if (image==null) {
            initComponents();
        }
        applyChanges(g2d);
        g.drawImage(image,0,0,null);
        painterDisplay.paintComponent(g);
    }

    private void initComponents () {
        image = new BufferedImage(getSize().width,getSize().height, BufferedImage.TYPE_INT_ARGB);
        g2d = (Graphics2D) image.getGraphics();
        enableAntialiasing(g2d);
        clear();
    }

    public void drawString (String number) {
        g2d.setFont(new Font("Montserrat" , Font.BOLD, 400));
        g2d.drawString(number, (int) ((getSize().width - getFontMetrics(g2d.getFont()).getStringBounds(number, g2d).getWidth()) / 2), (int) ((getSize().height - getFontMetrics(g2d.getFont()).getStringBounds(number, g2d).getHeight()) / 2 + getFontMetrics(g2d.getFont()).getAscent()));
        repaint();
    }

    private void applyChanges(Graphics2D g) {
        if (ManagerLobby.myLobby.getCanvas().getPencil().isPainting()) drawPoints(g);
    }

    private void drawPoints (Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(ManagerLobby.myLobby.getCanvas().getPencil().getDimension().width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        Point [] arrayOfPoints = ManagerLobby.myLobby.getCanvas().getPointList().toArray(new Point[ManagerLobby.myLobby.getCanvas().getPointList().size()]);
        for (int i = 0; i < arrayOfPoints.length - 1 ; i++) {
            if (lastPoint != null)
                g.drawLine(lastPoint.x, lastPoint.y, arrayOfPoints[i + 1].x, arrayOfPoints[i + 1].y);
            g.drawLine(arrayOfPoints[i].x, arrayOfPoints[i].y, arrayOfPoints[i + 1].x, arrayOfPoints[i + 1].y);
        }
        if (arrayOfPoints.length > 0)
        lastPoint=arrayOfPoints[arrayOfPoints.length-1];
    }

    public void clear() {
        drawBorders(g2d);
        drawBackground(g2d);
    }

    public void enableAntialiasing (Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void drawBackground (Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRoundRect(0, 0, this.getSize().width, this.getSize().height, 25, 25);
    }

    public void drawBorders (Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, getSize().width, getSize().height);
        g.setClip(0, getSize().height - 50, getSize().width, getSize().height);
        g.setColor(backgroundColor);
        g.fillRect(0, getSize().height-50, getSize().width, getSize().height);
        g.setClip(null);
    }

    @Override
    public void display() {
        repaint();
    }

    public void setEditable(boolean editable) {
        setEnabled(editable);
    }

    public void setBackgroundColor(Color color) {
        backgroundColor=color;
    }

}
