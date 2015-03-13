package controller.impl.sendcommand.statemessagedata.impl;

import model.canvas.Pencil;
import controller.impl.sendcommand.statemessagedata.interfaces.SendStateData;

import java.awt.*;

public class SendCanvasStateData extends SendStateData{

    public static SendCanvasStateData CLEAR = new SendCanvasStateData(true);

    private Point [] points;

    private boolean isCleared;
    private Pencil pencil;

    public SendCanvasStateData(boolean isCleared) {
        this.isCleared = isCleared;
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
