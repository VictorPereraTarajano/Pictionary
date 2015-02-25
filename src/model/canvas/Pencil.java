package model.canvas;

import java.awt.*;

public class Pencil {

    private Dimension dimension;
    private Color color;

    public Pencil() {
        color= Color.BLACK;
        dimension=new Dimension(10,10);
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Color getColor() {
        return color;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
