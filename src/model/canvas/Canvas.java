package model.canvas;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Canvas implements Serializable {

    private java.util.List<Point> pointList;

    public Canvas() {
        pointList=new ArrayList<>();
    }

    public void add(Point point) {
        pointList.add(point);
    }

    public Point getLastPoint () {
        return pointList.get(pointList.size()-1);
    }

    public void clear ( ){
        pointList.clear();
    }

    public boolean isEmpty ( ){
        return pointList.isEmpty();
    }
}
