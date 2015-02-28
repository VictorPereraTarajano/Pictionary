package model.canvas;

import java.awt.*;
import java.io.Serializable;

public class Pencil implements Serializable {

    private Dimension dimension;
    private Color color;
    private boolean isPainting=false;
    private Point position;

    public Pencil() {
        color= Color.BLACK;
        dimension=new Dimension(10,10);
        position=new Point(0,0);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Color getColor() {
        return color;
    }

    public boolean isPainting() {
        return isPainting;
    }

    public void setPainting(boolean isPainting) {
        this.isPainting = isPainting;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
