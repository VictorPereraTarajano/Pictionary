package model.timer;

import java.io.Serializable;

public class Timer implements Serializable {

    private int count;

    public Timer() {
        count=0;
    }

    public void setCount(int count) {
        this.count=count;
    }

    public int getCount () {
        return this.count;
    }

}
