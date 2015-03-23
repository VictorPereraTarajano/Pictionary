package view.ui.display.impl.swing;

import model.manager.ManagerLobby;
import view.persistence.impl.loaders.image.FactoryImageLoader;
import view.ui.dialog.impl.swing.CanvasOptionsDialog;
import view.ui.dialog.impl.swing.ReportPlayerDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CanvasDisplay extends JPanel implements view.ui.display.interfaces.CanvasDisplay {

    private Graphics2D g2d;
    public BufferedImage image = null;
    private Color backgroundColor;
    private Point lastPoint;
    private PencilDisplay pencilDisplay;
    private boolean editable=false;

    public CanvasDisplay(CanvasOptionsDialog canvasOptionsDialog, ReportPlayerDialog reportPlayerDialog) {
        super();
        setLayout(new BorderLayout());
        createWidgets(canvasOptionsDialog, reportPlayerDialog);
    }

    private void createWidgets(final CanvasOptionsDialog canvasOptionsDialog, final ReportPlayerDialog reportPlayerDialog) {
        createPencilDisplay();
        add(new JPanel () {
            {
                setLayout(new BorderLayout());
                add(canvasOptionsDialog, BorderLayout.WEST);
                add(reportPlayerDialog, BorderLayout.EAST);
                setOpaque(false);
            }
        }, BorderLayout.NORTH);
    }

    private void createPencilDisplay() {
        pencilDisplay = new PencilDisplay();
    }

    public void setLastPoint(Point lastPoint) {
        this.lastPoint = lastPoint;
    }

    @Override
    public void update(Graphics g) {
        paintComponent(g);
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        if (image==null)
            initComponents();
        applyChanges(g2d);
        g.drawImage(image,0,0,null);
        pencilDisplay.paintComponent(g);
    }

    private void initComponents () {
        image = new BufferedImage(getSize().width,getSize().height, BufferedImage.TYPE_INT_ARGB);
        g2d = (Graphics2D) image.getGraphics();
        enableAntialiasing(g2d);
        clear();
    }

    public void drawString (String number) {
        g2d.setFont(new Font("Montserrat" , Font.BOLD, 400));
        g2d.setColor(Color.DARK_GRAY);
        g2d.drawString(number, (int) ((getSize().width - getFontMetrics(g2d.getFont()).getStringBounds(number, g2d).getWidth()) / 2), (int) ((getSize().height - getFontMetrics(g2d.getFont()).getStringBounds(number, g2d).getHeight()) / 2 + getFontMetrics(g2d.getFont()).getAscent()));
    }

    private void applyChanges(Graphics2D g) {
        if (ManagerLobby.myLobby.getCanvas().getPencil().isPainting()) drawPoints(g);
    }

    private void drawPoints (Graphics2D g) {
        g.setColor(ManagerLobby.myLobby.getCanvas().getPencil().getColor());
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

    public boolean isEditable() {
        return editable;
    }

    public void enableAntialiasing (Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void drawBackground (Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRoundRect(0, 0, this.getSize().width, this.getSize().height, 25, 25);
        g.drawImage(FactoryImageLoader.TITLE_CANVAS,getWidth()/2 - FactoryImageLoader.TITLE_CANVAS.getWidth()/2,getHeight()/2 - FactoryImageLoader.TITLE_CANVAS.getHeight()/2,null);
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
        this.editable=editable;
    }

    public void setBackgroundColor(Color color) {
        backgroundColor=color;
    }

}
