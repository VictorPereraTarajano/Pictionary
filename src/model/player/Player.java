package model.player;

import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private String ip;

    public Player(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public String toString () {
        return name+","+ip;
    }

}
