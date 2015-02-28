package model.statemessagedata.impl;

import model.canvas.Pencil;
import model.statemessagedata.interfaces.SendStateData;

import java.awt.*;

public class SendCanvasStateData extends SendStateData{

    public static SendCanvasStateData CLEAR = new SendCanvasStateData(true);

    private Point [] points;

    private boolean isCleared;
    private Pencil pencil;

    public SendCanvasStateData(boolean isCleared) {
        this.isCleared = isCleared;
    }

    public SendCanvasStateData (Point [] points, Pencil pencil) {
        this.points=points;
        this.isCleared=false;
        this.pencil=pencil;
    }

    public Pencil getPencil() {
        return pencil;
    }

    public Point[] getPoints() {
        return points;
    }

    public boolean isCleared() {
        return isCleared;
    }

}
