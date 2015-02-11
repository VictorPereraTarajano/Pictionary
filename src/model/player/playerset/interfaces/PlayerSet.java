package model.player.playerset.interfaces;

import model.player.Player;

public interface PlayerSet {
    public void add (Player player);
    public Player get (int i);
    public void remove (Player player);
    public Player [] toArray ();
}
