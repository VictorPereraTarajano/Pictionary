package controller.impl.sendcommand.message.impl;

import controller.impl.sendcommand.message.interfaces.Message;
import controller.impl.sendcommand.messagedata.impl.ConfirmationData;

import java.io.Serializable;

public class ConfirmationMessage implements Message, Serializable {

    private ConfirmationData confirmationData;

    public ConfirmationMessage(ConfirmationData confirmationData) {
        this.confirmationData = confirmationData;
    }

    @Override
    public void open() {
        //new ConfirmationDisplay(confirmationData).display();
    }
}
