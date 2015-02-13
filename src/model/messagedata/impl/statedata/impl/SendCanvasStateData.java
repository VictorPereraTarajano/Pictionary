package model.messagedata.impl.statedata.impl;

import model.data.Data;
import model.messagedata.impl.statedata.interfaces.SendStateData;

import java.awt.*;

public class SendCanvasStateData extends SendStateData{

    private Point point;
    private boolean isCleared;
    private Color color;
    private Dimension size;

    public SendCanvasStateData (Point point) {
        this.point=point;
        this.isCleared=false;
    }

    public Point getPoint() {
        return point;
    }

    @Override
    public Data[] getData() {
        return new Data[0];
    }

}
