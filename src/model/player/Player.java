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
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Player) obj).getName().equals(name) && ((Player) obj).getIp().equals(ip);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        return result;
    }
}
