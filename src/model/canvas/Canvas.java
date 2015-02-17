package model.canvas;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Canvas implements Serializable {

    private final int MAX_SIZE_BUFFER=10;
    private java.util.List<Point> pointList;
    private boolean lock=false;

    public Canvas() {
        pointList=new ArrayList<>();
    }

    public void add(Point point) {
        if (pointList.size() >= MAX_SIZE_BUFFER) clear();
        pointList.add(point);
    }

    public Point getLastPoint () {
        return pointList.get(pointList.size()-1);
    }

    public void clear ( ){
        pointList.clear();
    }

    public int length () {
        return pointList.size();
    }

    public boolean isEmpty ( ){
        return pointList.isEmpty();
    }

    public boolean isLocked () {
        return lock;
    }

    public void lock() {
        lock=true;
    }

    public void unlock () {
        lock=false;
    }
}
