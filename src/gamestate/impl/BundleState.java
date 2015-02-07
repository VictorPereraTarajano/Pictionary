package gamestate.impl;

import gamestate.interfaces.State;

import java.io.Serializable;

public class BundleState extends State implements Serializable {
    @Override
    public void show() {
        System.out.println("BundleState");
    }
}
