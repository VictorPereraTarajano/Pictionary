package model.message.impl;

import model.message.interfaces.Message;

import java.io.Serializable;

public class ConfirmationMessage implements Message, Serializable {
    @Override
    public void open() {
        System.out.println("Confirmed delivery !!");
    }
}
