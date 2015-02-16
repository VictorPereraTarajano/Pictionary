package model.messagedata.impl.statedata.impl;

import model.messagedata.impl.statedata.interfaces.SendStateData;

import java.awt.*;

public class SendCanvasStateData extends SendStateData{

    public static SendCanvasStateData CLEAR = new SendCanvasStateData(true);

    private Point point;
    private boolean isCleared;
    private Color color;
    private Dimension size;

    public SendCanvasStateData(boolean isCleared) {
        this.isCleared = isCleared;
    }

    public SendCanvasStateData (Point point) {
        this.point=point;
        this.isCleared=false;
    }

    public Point getPoint() {
        return point;
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
}
