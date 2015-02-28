package model.canvas;

import java.awt.*;
import java.io.Serializable;
import java.util.*;

public class Canvas implements Serializable {

    public final int MAX_SIZE_BUFFER=20;
    private java.util.List<Point> pointList;

    private Pencil pencil;

    public Canvas() {
        pointList=new ArrayList<>();
        pencil=new Pencil();
    }

    public void setPencil(Pencil pencil) {
        this.pencil = pencil;
    }

    public Pencil getPencil() {
        return pencil;
    }

    public java.util.List<Point> getPointList() {
        return pointList;
    }

    public void add(Point point) {
        if (pointList.size() > MAX_SIZE_BUFFER)
            clear();
        pointList.add(point);
    }

    public void addAll (Point [] points) {
        for (Point point : points) pointList.add(point);
    }

    public void clear ( ){
        pointList.clear();
    }

    public boolean isEmpty ( ){
        return pointList.isEmpty();
    }

}
