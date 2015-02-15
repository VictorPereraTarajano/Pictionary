package model.playerset.interfaces;

import model.player.Player;

public interface PlayerSet {
    public void add (Player player);
    public void addAll(Player [] players);
    public Player get (int i);
    public void remove (Player player);
    public Player [] toArray ();
    public int length ();
    public void clear();
    public Player [] getAllWithoutMe ();
}
