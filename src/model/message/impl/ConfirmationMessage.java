package model.message.impl;

import model.message.interfaces.Message;
import model.messagedata.impl.ConfirmationData;
import view.ui.display.impl.swing.ConfirmationDisplay;

import java.io.Serializable;

public class ConfirmationMessage implements Message, Serializable {

    private ConfirmationData confirmationData;

    public ConfirmationMessage(ConfirmationData confirmationData) {
        this.confirmationData = confirmationData;
    }

    @Override
    public void open() {
        new ConfirmationDisplay(confirmationData).display();
    }
}
