package model.canvas;

import java.awt.*;
import java.io.Serializable;

public class Pencil implements Serializable {

    private Dimension dimension;
    private Color color;
    private boolean painting =false;
    private boolean visible =false;
    private Point position;

    public Pencil() {
        color= Color.BLACK;
        dimension=new Dimension(10,10);
        position=new Point(0,0);
    }
    public void setVisible(boolean isVisible) {
        this.visible = isVisible;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Color getColor() {
        return color;
    }

    public boolean isPainting() {
        return painting;
    }

    public void setPainting(boolean isPainting) {
        this.painting = isPainting;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isVisible() {
        return visible;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}
