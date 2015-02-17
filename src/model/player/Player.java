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

    @Override
    public boolean equals(Object obj) {
        Player player = (Player) obj;
        return player.getName().equals(name) && player.getIp().equals(ip);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        return result;
    }
}
