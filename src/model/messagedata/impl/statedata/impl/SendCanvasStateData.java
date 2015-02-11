package model.messagedata.impl.statedata.impl;

import model.data.Data;
import model.messagedata.impl.statedata.interfaces.SendStateData;

import java.awt.*;

public class SendCanvasStateData extends SendStateData{

    private Point point;

    public SendCanvasStateData(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    @Override
    public Data[] getData() {
        return new Data[0];
    }

}
