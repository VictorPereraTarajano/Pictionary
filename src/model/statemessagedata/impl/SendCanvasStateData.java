package model.statemessagedata.impl;

import model.statemessagedata.interfaces.SendStateData;

import java.awt.*;

public class SendCanvasStateData extends SendStateData{

    public static SendCanvasStateData CLEAR = new SendCanvasStateData(true);

    private Point [] points;

    private boolean isCleared;
    private Color color;
    private Dimension size;

    public SendCanvasStateData(boolean isCleared) {
        this.isCleared = isCleared;
    }


    public SendCanvasStateData (Point [] points) {
        this.points=points;
        this.isCleared=false;
    }

    public Point[] getPoints() {
        return points;
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
