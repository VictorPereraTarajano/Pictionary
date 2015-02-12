package model.messagedata.impl.statedata.impl;

import model.data.Data;
import model.messagedata.impl.statedata.interfaces.SendStateData;

import java.awt.*;

public class SendCanvasStateData extends SendStateData{

    private Point point;
    private boolean isCleared;
    private Color color;
    private Dimension size;

    public SendCanvasStateData(Point point, boolean isCleared, Color color, Dimension size) {
        this.point = point;
        this.isCleared = isCleared;
        this.color = color;
        this.size = size;
    }

    public SendCanvasStateData (Point point) {
        this.point=point;
        this.isCleared=false;
    }

    public boolean isCleared() {
        return isCleared;
    }

    public Color getColor() {
        return color;
    }

    public Dimension getSize() {
        return size;
    }

    public Point getPoint() {
        return point;
    }

    @Override
    public Data[] getData() {
        return new Data[0];
    }

}
